package com.example.mealdb.data.repository

import com.example.mealdb.data.model.MealDetail
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface MealDetailRepository {

    fun getFavoriteMeal(): Observable<List<MealDetail>>
    fun insertMeal(mealDetail: MealDetail): Completable
    fun deleteMeal(mealDetail: MealDetail): Completable
    fun updateMeal(mealDetail: MealDetail): Completable
    fun isFavoriteMeal(id: Int): Single<Int>
    fun getMealById(id: String): Observable<List<MealDetail>>
}
