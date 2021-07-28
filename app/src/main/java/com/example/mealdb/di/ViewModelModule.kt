package com.example.mealdb.di

import com.example.mealdb.ui.detail.MealDetailViewModel
import com.example.mealdb.ui.favorite.FavoriteViewModel
import com.example.mealdb.ui.home.HomeViewModel
import com.example.mealdb.ui.imagezoom.ImageZoomViewModel
import com.example.mealdb.ui.meal.MealViewModel
import com.example.mealdb.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { MealViewModel(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { MealDetailViewModel(get(),get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { ImageZoomViewModel() }
}
