package com.example.mealdb.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.mealdb.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MealDb)

        setContentView(R.layout.activity_main)

        val navigationHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentNavigationHost) as NavHostFragment
        val navigationController = navigationHostFragment.navController
        navigationController.addOnDestinationChangedListener { _, destination, _ ->
            bottomNavigationView.isVisible = destination.id in mainFragments
        }
        bottomNavigationView.apply {
            setupWithNavController(navigationController)
            setOnNavigationItemSelectedListener {
                if (it.itemId != bottomNavigationView.selectedItemId) {
                    NavigationUI.onNavDestinationSelected(it, navigationController)
                }
                true
            }
        }
    }
    companion object {
        val mainFragments = listOf(
            R.id.fragmentHome,
            R.id.fragmentFavorite,
        )
    }
}
