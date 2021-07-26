package com.example.mealdb.ui.imagezoom

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mealdb.R
import com.example.mealdb.base.BaseFragment
import com.example.mealdb.databinding.FragmentImageZoomBinding
import kotlinx.android.synthetic.main.fragment_meal.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ImageZoomFragment:BaseFragment<FragmentImageZoomBinding>() {
    override val layoutResource = R.layout.fragment_image_zoom
    override val viewModel by viewModel<ImageZoomViewModel>()

    private val args: ImageZoomFragmentArgs by navArgs()

    override fun setupViews() {
    }

    override fun setupData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            imageVM = viewModel
        }
        viewModel.loadImage(args.image.strMealThumb)
    }

    override fun setupActions() {
        binding?.apply {
            imageCancel.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}
