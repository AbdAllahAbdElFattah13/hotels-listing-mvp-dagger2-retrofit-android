package com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel

import android.app.Activity
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
import com.tajawa.abdallah.tajawal_android_task.R
import com.tajawa.abdallah.tajawal_android_task.TajawalApp
import kotlinx.android.synthetic.main.activity_details_hotel.*
import javax.inject.Inject


class DetailsHotelActivity : AppCompatActivity(), DetailsHotelContract.View {

    @Inject
    lateinit var mPresenter: DetailsHotelContract.Presenter
    private var isImageFitScreen: Boolean = false

    private var mResult: Int = RESULT_CANCELED

    // Note: 19-Jul-17 this might fail according to the following link "https://stackoverflow.com/questions/42673531/converting-dp-to-px-without-context"
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_hotel)

        if (savedInstanceState != null) mResult = Activity.RESULT_OK

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
        toggleImageFullScreen()
    }

    override fun onBackPressed() {
        if (isImageFitScreen) {
            toggleImageFullScreen()
        } else {
            setResult(mResult)
            finish()
            super.onBackPressed()
        }
    }
}
