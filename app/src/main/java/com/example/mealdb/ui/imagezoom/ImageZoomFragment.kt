package com.example.mealdb.ui.imagezoom

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mealdb.R
import com.example.mealdb.base.BaseFragment
import com.example.mealdb.databinding.FragmentImageZoomBinding
import com.example.mealdb.utils.BASE_URL
import com.example.mealdb.utils.FOLDER
import com.example.mealdb.utils.MESSAGE_SUCCESS
import com.example.mealdb.utils.showToast
import kotlinx.android.synthetic.main.fragment_image_zoom.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ImageZoomFragment : BaseFragment<FragmentImageZoomBinding>() {
    override val layoutResource = R.layout.fragment_image_zoom
    override val viewModel by viewModel<ImageZoomViewModel>()

    private val args: ImageZoomFragmentArgs by navArgs()

    private var scaleGestureDetector: ScaleGestureDetector? = null
    private var scaleFactor = 1.0f

    @SuppressLint("ClickableViewAccessibility")
    override fun setupViews() {
        scaleGestureDetector = ScaleGestureDetector(context, ScaleListener())
        view?.setOnTouchListener { _: View?, event: MotionEvent? ->
            scaleGestureDetector?.onTouchEvent(event)
            true
        }
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
            imageDowload.setOnClickListener {
                if (onRequestPermissionsResult()) {
                    val url = args.image.strMealThumb.substring(BASE_URL.length)
                    viewModel.downloadImg(url)
                    context?.showToast(MESSAGE_SUCCESS + " " + FOLDER)
                }
            }
        }
    }

    fun onRequestPermissionsResult(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (context?.let {
                    ContextCompat.checkSelfPermission(
                        it,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                } != PackageManager.PERMISSION_GRANTED
            ) {
                return makeRequest()
            }
        }
        return true
    }

    private fun makeRequest(): Boolean {
        activity?.let {
            ActivityCompat.requestPermissions(
                it,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                1
            )
        }
        return if (context?.let {
                ContextCompat.checkSelfPermission(
                    it,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            } != PackageManager.PERMISSION_GRANTED
        ) {
            false
        } else true
    }

    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(scaleGestureDetector: ScaleGestureDetector): Boolean {
            scaleFactor *= scaleGestureDetector.scaleFactor
            scaleFactor = DIMENSION_01.coerceAtLeast(scaleFactor.coerceAtMost(DIMENSION_10))
            imageZoom.scaleX = scaleFactor
            imageZoom.scaleY = scaleFactor
            return true
        }
    }

    companion object {
        const val DIMENSION_10 = 10f
        const val DIMENSION_01 = .1f
    }
}
