package com.example.mealdb.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mealdb.base.BaseViewModel
import com.example.mealdb.data.model.Meal
import com.example.mealdb.data.model.MealDetail
import com.example.mealdb.data.repository.MealDetailRepository
import com.example.mealdb.data.repository.MealRepository
import com.google.gson.Gson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import org.json.JSONObject
import kotlin.random.Random

class MealDetailViewModel(
    private val mealDetailRepository: MealDetailRepository,
    private val mealRepository: MealRepository
) : BaseViewModel() {

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean>
        get() = _isFavorite

    private val _meal = MutableLiveData<List<MealDetail>>()
    val meal: LiveData<List<MealDetail>>
        get() = _meal

    private val _mealRelated = MutableLiveData<List<Meal>>()
    val mealRelated: LiveData<List<Meal>>
        get() = _mealRelated

    private val _ingredient = MutableLiveData<String>()
    val ingredient: LiveData<String>
        get() = _ingredient

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    fun getMealDetail(id: String) {
        _isLoading.value = true
        mealDetailRepository.getMealById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _meal.value = it
                getMealByCategory(it.get(0).strCategory)
                Log.e("Tag",it.get(0).idMeal.toString())
                _ingredient.value = StringBuilder().run {
                    for (i in 1..20) {
                        var ingredient = ""
                        if (JSONObject(Gson().toJson(it.get(0))).has("$INGREDIEN$i"))
                            ingredient = JSONObject(Gson().toJson(it.get(0))).getString("$INGREDIEN$i")
                        Log.e("Tag",i.toString()+" " + ingredient)
                        if (ingredient.isEmpty() || ingredient == "null") break
                        append(ingredient).append('\n')
                    }
                    substring(0, (length - 2))
                }
                _isLoading.value = false
            }, {
                _isLoading.value = false
                _error.value = it.message.toString()
            })
            .addTo(disposable)
    }

    private fun getMealByCategory(category: String) {
        mealRepository.getMealByCategory(category)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _mealRelated.value = randomMeal(it)
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposable)
    }

    private fun randomMeal(listMeal: List<Meal>): List<Meal>{
        var listRelate = mutableListOf<Meal>()
        for (i in 1..10){
            listRelate.add(listMeal.get(Random.nextInt(0,listMeal.size-1)))
        }
        return listRelate
    }

    fun checkFavorite(id: String) {
        mealDetailRepository.isFavoriteMeal(id.toInt())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _isFavorite.value = if (it == 0) false else true
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposable)
    }

    fun updateFavorite() {
        meal.value?.get(0)?.let { it ->
            if (isFavorite.value == true) {
                mealDetailRepository.deleteMeal(it)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        _isFavorite.value = false
                    }, {
                        _error.value = it.message.toString()
                    })
                    .addTo(disposable)
            } else {
                mealDetailRepository.insertMeal(it)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        _isFavorite.value = true
                    }, {
                        _error.value = it.message.toString()
                    })
                    .addTo(disposable)
            }

        }
    }

    companion object {
        const val INGREDIEN = "strIngredient"
    }
}
