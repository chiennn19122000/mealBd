package com.example.mealdb.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mealdb.base.BaseViewModel
import com.example.mealdb.data.model.MealDetail
import com.example.mealdb.data.repository.MealDetailRepository
import com.google.gson.Gson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import org.json.JSONObject

class MealDetailViewModel(
    private val mealDetailRepository: MealDetailRepository
) : BaseViewModel() {

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean>
        get() = _isFavorite

    private val _meal = MutableLiveData<List<MealDetail>>()
    val meal: LiveData<List<MealDetail>>
        get() = _meal

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
                _ingredient.value = StringBuilder().run {
                    for (i in 1..20) {
                        val ingredient =
                            JSONObject(Gson().toJson(it.get(0))).getString("$INGREDIEN$i")
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
