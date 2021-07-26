package com.example.mealdb.data.source.remote

import com.example.mealdb.data.model.Meal
import com.example.mealdb.data.model.MealResponse
import com.example.mealdb.data.source.MealDataSource
import io.reactivex.rxjava3.core.Observable

class MealRemoteDataSource(
    private val api: Api
) : MealDataSource {

    override fun getMealByCategory(category: String): Observable<MealResponse> =
        api.getMealByCategory(category)

    override fun searchMeal(keyword: String): Observable<MealResponse> = api.searchMeal(keyword)
}
