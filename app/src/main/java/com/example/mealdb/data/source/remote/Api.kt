package com.example.mealdb.data.source.remote

import com.example.mealdb.data.model.*
import io.reactivex.rxjava3.core.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @GET("api/json/v1/1/categories.php")
    fun getCategory(): Observable<CategoryResponse>

    @GET("api/json/v1/1/filter.php")
    fun getMealByCategory(
        @Query("c") category: String
    ): Observable<MealResponse>

    @GET("api/json/v1/1/search.php")
    fun searchMeal(@Query("s") key: String): Observable<MealResponse>

    @GET("api/json/v1/1/lookup.php")
    fun getMealById(@Query("i") id: String): Observable<MealDetailResponse>

    @Streaming
    @GET("{url}")
    fun downloadFileWithFixedUrl(@Path("url") url: String): Call<ResponseBody>
}
