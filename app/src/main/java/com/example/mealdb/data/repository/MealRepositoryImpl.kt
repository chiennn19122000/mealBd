package com.example.mealdb.data.repository

import com.example.mealdb.data.model.Meal
import com.example.mealdb.data.model.MealResponse
import com.example.mealdb.data.source.MealDataSource
import io.reactivex.rxjava3.core.Observable

class MealRepositoryImpl(
    private val remote: MealDataSource
) : MealRepository {

    override fun getMealByCategory(category: String): Observable<List<Meal>> =
        remote.getMealByCategory(category).map { it.data }

    override fun searchMeal(keyword: String): Observable<List<Meal>> =
        remote.searchMeal(keyword).map { it.data }
}
