package com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import com.tajawa.abdallah.tajawal_android_task.Activitys.ImageLoaderUtil
import com.tajawa.abdallah.tajawal_android_task.PresentationLayer.Activitys.FullScreenImage.FullScreenImageActivity
import com.tajawa.abdallah.tajawal_android_task.R
import com.tajawa.abdallah.tajawal_android_task.TajawalApp
import kotlinx.android.synthetic.main.activity_details_hotel.*
import javax.inject.Inject


class DetailsHotelActivity : AppCompatActivity(), DetailsHotelContract.View {

    @Inject
    lateinit var mPresenter: DetailsHotelContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_hotel)

        tv_hotel_high_rate.paintFlags = tv_hotel_high_rate.paintFlags + Paint.STRIKE_THRU_TEXT_FLAG

        //Injecting Dependencies
        (application as TajawalApp).mTajawalComponent.inject(this)
        mPresenter.setView(this)
    }

    override fun setImageUrl(imageUrl: String) {
        ImageLoaderUtil.loadImage(url = imageUrl, imageView = iv_hotel_image, h = -1)
    }

    override fun setHotelName(name: String) {
        tv_hotel_name.text = name
    }

    override fun setHotelAddress(address: String) {
        tv_hotel_address.text = address
    }

    override fun setLowRate(lowRate: String) {
        tv_hotel_low_rate.text = lowRate
    }

    override fun setHighRate(highRate: String) {
        tv_hotel_high_rate.text = highRate
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
        // Respond to the action bar's Up/Home button
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> {
                true
            }
        }
    }

    fun onImageViewClick(view: View) {
        mPresenter.onHotelImageClick()
    }

    override fun startFullScreenActivity() {
        startActivity(Intent(this, FullScreenImageActivity::class.java))
    }
}
