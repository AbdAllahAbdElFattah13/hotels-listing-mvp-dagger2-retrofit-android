package com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel

import android.content.res.Resources
import android.graphics.Paint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import com.tajawa.abdallah.tajawal_android_task.Activitys.ImageLoaderUtil
import com.tajawa.abdallah.tajawal_android_task.DataLayer.DataRepository
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Volley.RemoteDataSourceUsingVolley
import com.tajawa.abdallah.tajawal_android_task.R
import kotlinx.android.synthetic.main.activity_details_hotel.*


class DetailsHotelActivity : AppCompatActivity(), DetailsHotelContract.View {

    private var isImageFitScreen: Boolean = false

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
        // Respond to the action bar's Up/Home button
            android.R.id.home -> {
                if (isImageFitScreen) {
                    toggleImageFullScreen()
                    return true
                }
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    // Note: 19-Jul-17 this might fail accourding to the following link "https://stackoverflow.com/questions/42673531/converting-dp-to-px-without-context"
    private fun fromIntToDp(n: Int): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, n.toFloat(), Resources.getSystem().displayMetrics).toInt()

    private fun toggleImageFullScreen() {
        if (isImageFitScreen) {
            iv_hotel_image.layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, fromIntToDp(250))
            iv_hotel_image.adjustViewBounds = true
            rv_hotel_data_without_image.visibility = View.VISIBLE
        } else {
            iv_hotel_image.layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
            iv_hotel_image.scaleType = ImageView.ScaleType.FIT_XY
            iv_hotel_image.adjustViewBounds = true
            rv_hotel_data_without_image.visibility = View.GONE
        }
        isImageFitScreen = !isImageFitScreen
    }

    fun onImageViewClick(view: View) {
        toggleImageFullScreen()
    }
}
