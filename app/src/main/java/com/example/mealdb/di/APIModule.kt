package com.example.mealdb.di

import com.example.mealdb.data.source.remote.Api
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(Api::class.java) }
}
