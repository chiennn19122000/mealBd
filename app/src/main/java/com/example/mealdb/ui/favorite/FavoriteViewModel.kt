package com.example.mealdb.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mealdb.base.BaseViewModel
import com.example.mealdb.data.model.MealDetail
import com.example.mealdb.data.repository.MealDetailRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class FavoriteViewModel(
    private val mealDetailRepository: MealDetailRepository
) : BaseViewModel() {

    private val _meal = MutableLiveData<List<MealDetail>>()
    val meal: LiveData<List<MealDetail>>
        get() = _meal

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        getMealFavorite()
    }

    private fun getMealFavorite(){
        _isLoading.value = true
       mealDetailRepository.getFavoriteMeal()
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe({
               _meal.value = it
               _isLoading.value = false
           }, {
               _isLoading.value = false
               _error.value = it.message.toString()
           })
           .addTo(disposable)
    }
}
