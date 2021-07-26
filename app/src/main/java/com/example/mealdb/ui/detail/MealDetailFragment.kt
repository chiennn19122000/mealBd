package com.example.mealdb.ui.detail

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mealdb.R
import com.example.mealdb.base.BaseFragment
import com.example.mealdb.databinding.FragmentMealDetailBinding
import com.example.mealdb.ui.meal.MealFragmentDirections
import kotlinx.android.synthetic.main.fragment_meal_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealDetailFragment: BaseFragment<FragmentMealDetailBinding>() {
    override val layoutResource = R.layout.fragment_meal_detail
    override val viewModel by viewModel<MealDetailViewModel>()

    private val args: MealDetailFragmentArgs by navArgs()

    override fun setupViews() {
    }

    override fun setupData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            mealDetailVM = viewModel
        }
        viewModel.getMealDetail(args.meal.idMeal)
        viewModel.checkFavorite(args.meal.idMeal)
    }

    override fun setupActions() {
        binding?.apply {
            buttonBack.setOnClickListener {
                findNavController().popBackStack()
            }
            buttonFavorite.setOnClickListener {
                viewModel.updateFavorite()
            }
            imageMealDetail.setOnClickListener {
                val action = MealDetailFragmentDirections.actionMealDetailToImage(args.meal)
                findNavController().navigate(action)
            }
        }
    }
}
