package com.tajawa.abdallah.tajawal_android_task.PresentationLayer.Activitys.FullScreenImage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.tajawa.abdallah.tajawal_android_task.Activitys.ImageLoaderUtil
import com.tajawa.abdallah.tajawal_android_task.R
import com.tajawa.abdallah.tajawal_android_task.TajawalApp
import kotlinx.android.synthetic.main.activity_full_screen.*
import javax.inject.Inject

class FullScreenImageActivity : AppCompatActivity(), FullScreenImageContract.View {
    @Inject
    lateinit var mPresenter: FullScreenImageContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen)

        (application as TajawalApp).mTajawalComponent.inject(this)
    }

    override fun onResume() {
        super.onResume()
        mPresenter.setView(this)
    }

    override fun onPause() {
        super.onPause()
        mPresenter.removeView()
    }

    override fun setImageUrl(url: String) {
        ImageLoaderUtil.loadImage(url, iv_hotel_image, -1)
    }

    override fun finishView() {
        finish()
    }

    fun onImageViewClick(v: View) {
        mPresenter.onImageClick()
    }
}
