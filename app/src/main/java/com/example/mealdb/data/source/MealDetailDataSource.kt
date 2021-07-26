package com.example.mealdb.data.source

import com.example.mealdb.data.model.MealDetail
import com.example.mealdb.data.model.MealDetailResponse
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface MealDetailDataSource {
    interface Local {
        fun getFavoriteMeal(): Observable<List<MealDetail>>
        fun insertMeal(mealDetail: MealDetail): Completable
        fun deleteMeal(mealDetail: MealDetail): Completable
        fun updateMeal(mealDetail: MealDetail): Completable
        fun isFavoriteMeal(id: Int): Single<Int>
    }

    interface Remote {
        fun getMealById(id: String): Observable<MealDetailResponse>
    }
}
