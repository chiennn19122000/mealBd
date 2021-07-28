package com.example.mealdb.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mealdb.base.BaseViewModel
import com.example.mealdb.data.model.Meal
import com.example.mealdb.data.repository.MealRepository
import com.example.mealdb.utils.EXCEPTION_EMPTY_SEARCH_RESULT
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchViewModel(
    private val mealRepository: MealRepository
) : BaseViewModel() {

    private val _searchMeal = MutableLiveData<List<Meal>>()
    val searchMeal: LiveData<List<Meal>>
        get() = _searchMeal

    private val _isEmpty = MutableLiveData<Boolean>()
    val isEmpty: LiveData<Boolean>
        get() = _isEmpty

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getSeachMeal(keyword: String) {
        _isLoading.value = true
        mealRepository.searchMeal(keyword)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _isLoading.value = false
                _searchMeal.value = it
                _isEmpty.value = false
            }, {
                _isLoading.value = false
                if (it.message.toString() == EXCEPTION_EMPTY_SEARCH_RESULT) {
                    _isEmpty.value = true
                    _searchMeal.value = emptyList()
                } else {
                    _error.value = it.message.toString()
                }
            })
            .addTo(disposable)
    }
}
