package com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel

import android.graphics.Paint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tajawa.abdallah.tajawal_android_task.Activitys.ImageLoaderUtil
import com.tajawa.abdallah.tajawal_android_task.DataLayer.DataRepository
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Volley.RemoteDataSourceUsingVolley
import com.tajawa.abdallah.tajawal_android_task.R
import kotlinx.android.synthetic.main.activity_details_hotel.*


class DetailsHotelActivity : AppCompatActivity(), DetailsHotelContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_hotel)

        tv_hotel_high_rate.paintFlags = tv_hotel_high_rate.paintFlags + Paint.STRIKE_THRU_TEXT_FLAG

        DetailsHotelPresenter(
                DataRepository.getInstance(
                        RemoteDataSourceUsingVolley.getInstance(this)
                ), this).start()
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
}
