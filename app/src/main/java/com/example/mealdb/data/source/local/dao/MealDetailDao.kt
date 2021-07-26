package com.example.mealdb.data.source.local.dao

import androidx.room.*
import com.example.mealdb.data.model.MealDetail
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface MealDetailDao {
    @Query("SELECT * FROM meal")
    fun getFavoriteMeal(): Observable<List<MealDetail>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMeal(mealDetail: MealDetail): Completable

    @Delete
    fun deleteMeal(mealDetail: MealDetail): Completable

    @Update
    fun updateMeal(mealDetail: MealDetail): Completable

    @Query("SELECT COUNT(idMeal) FROM meal WHERE meal.idMeal =:id")
    fun isFavoriteMeal(id: Int): Single<Int>
}
