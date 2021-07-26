package com.example.mealdb.data.source.local

import com.example.mealdb.data.model.MealDetail
import com.example.mealdb.data.source.MealDetailDataSource
import com.example.mealdb.data.source.local.dao.MealDetailDao
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class MealDetailLocalDataSource(
    private val mealDetailDao: MealDetailDao
) : MealDetailDataSource.Local {
    override fun getFavoriteMeal(): Observable<List<MealDetail>> =
        mealDetailDao.getFavoriteMeal()

    override fun insertMeal(mealDetail: MealDetail): Completable =
        mealDetailDao.insertMeal(mealDetail)

    override fun deleteMeal(mealDetail: MealDetail): Completable = mealDetailDao.deleteMeal(mealDetail)

    override fun updateMeal(mealDetail: MealDetail): Completable =
        mealDetailDao.updateMeal(mealDetail)

    override fun isFavoriteMeal(id: Int): Single<Int> = mealDetailDao.isFavoriteMeal(id)
}
