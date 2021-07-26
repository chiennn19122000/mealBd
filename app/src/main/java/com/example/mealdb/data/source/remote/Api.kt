package com.example.mealdb.data.source.remote

import com.example.mealdb.data.model.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface Api {
    @GET("categories.php")
    fun getCategory(): Observable<CategoryResponse>

    @GET("filter.php")
    fun getMealByCategory(
        @Query("c") category: String
    ): Observable<MealResponse>

    @GET("search.php")
    fun searchMeal(@Query("s") key: String): Observable<MealResponse>

    @GET("lookup.php")
    fun getMealById(@Query("i") id: String): Observable<MealDetailResponse>
}
