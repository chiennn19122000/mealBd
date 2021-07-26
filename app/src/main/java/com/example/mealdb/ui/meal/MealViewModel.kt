package com.example.mealdb.ui.meal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mealdb.base.BaseViewModel
import com.example.mealdb.data.model.Meal
import com.example.mealdb.data.repository.MealRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class MealViewModel(
    private val mealRepository: MealRepository
) : BaseViewModel() {

    private val _mealBycategory = MutableLiveData<List<Meal>>()
    val mealByCategory: LiveData<List<Meal>>
        get() = _mealBycategory

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getMealByCategory(category: String) {
        _isLoading.value = true
        mealRepository.getMealByCategory(category)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _isLoading.value = false
                _mealBycategory.value = it
            }, {
                _isLoading.value = false
                _error.value = it.message.toString()
            })
            .addTo(disposable)
    }
}
