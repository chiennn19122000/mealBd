package com.example.mealdb.data.repository

import com.example.mealdb.data.model.MealDetail
import com.example.mealdb.data.model.MealDetailResponse
import com.example.mealdb.data.source.MealDetailDataSource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class MealDetailRepositoryImpl(
    private val local: MealDetailDataSource.Local,
    private val remote: MealDetailDataSource.Remote
) : MealDetailRepository {

    override fun getFavoriteMeal(): Observable<List<MealDetail>> = local.getFavoriteMeal()

    override fun insertMeal(mealDetail: MealDetail): Completable = local.insertMeal(mealDetail)

    override fun deleteMeal(mealDetail: MealDetail): Completable = local.deleteMeal(mealDetail)

    override fun updateMeal(mealDetail: MealDetail): Completable = local.updateMeal(mealDetail)

    override fun isFavoriteMeal(id: Int): Single<Int> = local.isFavoriteMeal(id)

    override fun getMealById(id: String): Observable<List<MealDetail>> = remote.getMealById(id).map { it.data }
}
