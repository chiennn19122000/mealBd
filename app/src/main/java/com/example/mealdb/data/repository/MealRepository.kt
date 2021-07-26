package com.example.mealdb.data.repository

import com.example.mealdb.data.model.Meal
import io.reactivex.rxjava3.core.Observable

interface MealRepository {

    fun getMealByCategory(category: String): Observable<List<Meal>>
    fun searchMeal(keyword: String): Observable<List<Meal>>
}
