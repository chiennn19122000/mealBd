package com.example.mealdb.data.source.remote

import com.example.mealdb.data.model.MealDetail
import com.example.mealdb.data.model.MealDetailResponse
import com.example.mealdb.data.source.MealDetailDataSource
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class MealDetailRemoteDataSource(
    private val api: Api
): MealDetailDataSource.Remote {

    override fun getMealById(id: String): Observable<MealDetailResponse> = api.getMealById(id)
}
