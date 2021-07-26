package com.example.mealdb

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mealdb.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MealDbApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MealDbApplication)
            modules(
                networkModule,
                apiModule,
                databaseModule,
                repositoryModule,
                viewModelModule
            )
        }
    }
}
