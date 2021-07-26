package com.example.mealdb.data.source

import com.example.mealdb.data.model.Meal
import com.example.mealdb.data.model.MealResponse
import io.reactivex.rxjava3.core.Observable

interface MealDataSource {
    fun getMealByCategory(category: String): Observable<MealResponse>
    fun searchMeal(keyword: String): Observable<MealResponse>
}
