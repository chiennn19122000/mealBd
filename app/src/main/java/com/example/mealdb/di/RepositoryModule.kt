package com.example.mealdb.di

import com.example.mealdb.data.repository.*
import com.example.mealdb.data.source.CategoryDataSource
import com.example.mealdb.data.source.MealDataSource
import com.example.mealdb.data.source.MealDetailDataSource
import com.example.mealdb.data.source.local.MealDetailLocalDataSource
import com.example.mealdb.data.source.remote.CategoryRemoteDataSource
import com.example.mealdb.data.source.remote.MealDetailRemoteDataSource
import com.example.mealdb.data.source.remote.MealRemoteDataSource
import org.koin.dsl.module

val repositoryModule = module {
    single<MealDetailDataSource.Local> { MealDetailLocalDataSource(get()) }
    single<MealDetailDataSource.Remote> { MealDetailRemoteDataSource(get()) }
    single<MealDetailRepository> { MealDetailRepositoryImpl(get(), get()) }
    single<MealDataSource> { MealRemoteDataSource(get()) }
    single<MealRepository> { MealRepositoryImpl(get()) }
    single<CategoryDataSource> { CategoryRemoteDataSource(get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }
}
