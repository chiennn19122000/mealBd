package com.example.mealdb.ui.meal

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mealdb.R
import com.example.mealdb.base.BaseFragment
import com.example.mealdb.data.model.Meal
import com.example.mealdb.databinding.FragmentMealBinding
import com.example.mealdb.ui.adapter.MealAdapter
import com.example.mealdb.ui.home.HomeFragmentDirections
import com.example.mealdb.utils.hideKeyboard
import com.example.mealdb.utils.showKeyboard
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealFragment: BaseFragment<FragmentMealBinding>() {
    override val layoutResource: Int
        get() = R.layout.fragment_meal
    override val viewModel by viewModel<MealViewModel>()

    private val mealAdapter = MealAdapter(::clickMeal)
    private val args: MealFragmentArgs by navArgs()

    override fun setupViews() {

    }

    override fun setupData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            mealVM = viewModel
            recyclerMeal.adapter = mealAdapter
        }
        viewModel.getMealByCategory(args.category.strCategory)
    }

    override fun setupActions() {
        binding?.apply {
            buttonBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun clickMeal(meal: Meal){
        val action = MealFragmentDirections.actionMealToMealDetail(meal)
        findNavController().navigate(action)
    }
}
