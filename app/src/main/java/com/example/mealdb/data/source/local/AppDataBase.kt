package com.example.mealdb.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mealdb.data.model.MealDetail
import com.example.mealdb.data.source.local.AppDatabase.Companion.DATABASE_VERSION
import com.example.mealdb.data.source.local.AppDatabase.Companion.EXPORT_SCHEME
import com.example.mealdb.data.source.local.dao.MealDetailDao

@Database(
    entities = [MealDetail::class],
    version = DATABASE_VERSION,
    exportSchema = EXPORT_SCHEME
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun mealDetailDao(): MealDetailDao

    companion object {
        const val DATABASE_NAME = "MealDb"
        const val DATABASE_VERSION = 1
        const val EXPORT_SCHEME = false
    }
}
