package com.example.mealdb.ui.favorite

import androidx.navigation.fragment.findNavController
import com.example.mealdb.R
import com.example.mealdb.base.BaseFragment
import com.example.mealdb.data.model.Category
import com.example.mealdb.data.model.Meal
import com.example.mealdb.data.model.MealDetail
import com.example.mealdb.databinding.FragmentFavoriteBinding
import com.example.mealdb.ui.adapter.FavoriteAdapter
import com.example.mealdb.ui.home.HomeFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment: BaseFragment<FragmentFavoriteBinding>() {
    override val layoutResource = R.layout.fragment_favorite
    override val viewModel by viewModel<FavoriteViewModel>()

    private val adapter = FavoriteAdapter(::clickMeal)

    override fun setupViews() {
    }

    override fun setupData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            favoriteVM = viewModel
            recyclerFavorite.adapter = adapter
        }
    }

    override fun setupActions() {
    }

    private fun clickMeal(mealDetail: MealDetail) {
        val meal = Meal(mealDetail.strMeal,mealDetail.strMealThumb,mealDetail.idMeal.toString())
        val action = FavoriteFragmentDirections.actionFavoriteToMealDetail(meal)
        findNavController().navigate(action)
    }
}
