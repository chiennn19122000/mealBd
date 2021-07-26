package com.example.mealdb.ui.home

import androidx.navigation.fragment.findNavController
import com.example.mealdb.R
import com.example.mealdb.base.BaseFragment
import com.example.mealdb.data.model.Category
import com.example.mealdb.databinding.FragmentHomeBinding
import com.example.mealdb.ui.adapter.CategoryAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment: BaseFragment<FragmentHomeBinding>() {
    override val layoutResource: Int
        get() = R.layout.fragment_home
    override val viewModel by viewModel<HomeViewModel>()

    private val categoryAdapter = CategoryAdapter(::clickCategory)

    override fun setupViews() {
    }

    override fun setupData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            homeVM = viewModel
            recyclerCategories.adapter = categoryAdapter
        }
    }

    override fun setupActions() {
        binding?.apply {
            textSearch.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeToSearch()
                findNavController().navigate(action)
            }
        }
    }

    private fun clickCategory(category: Category) {
        val action = HomeFragmentDirections.actionHomeToMeal(category)
        findNavController().navigate(action)
    }
}
