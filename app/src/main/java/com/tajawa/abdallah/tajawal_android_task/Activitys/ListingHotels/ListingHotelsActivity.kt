package com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel.DetailsHotelActivity
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter.HotelItemsAdapter
import com.tajawa.abdallah.tajawal_android_task.DataLayer.DataRepository
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Volley.RemoteDataSourceUsingVolley
import com.tajawa.abdallah.tajawal_android_task.R
import kotlinx.android.synthetic.main.activity_listing_hotels.*
import kotlinx.android.synthetic.main.error_view.*

class ListingHotelsActivity : AppCompatActivity(), ListingHotelsContract.View {

    private var mLoading: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listing_hotels)

        rv_hotels_listing.layoutManager = LinearLayoutManager(this)
        ListingHotelsPresenter(
                DataRepository.getInstance(
                        RemoteDataSourceUsingVolley.getInstance(this)
                ), this
        ).start()
    }

    private fun showError(errMsg: String) {
        if (errMsg.isEmpty()) {
            error_view.visibility = View.GONE
        } else {
            error_view.visibility = View.VISIBLE
            tv_error_msg.text = errMsg
        }
    }

    private fun showLoading(loading: Boolean) {
        if (loading) {
            loading_view.visibility = View.VISIBLE
        } else {
            loading_view.visibility = View.GONE
        }
    }

    private fun showData(show: Boolean) {
        if (show) {
            rv_hotels_listing.visibility = View.VISIBLE
        } else {
            rv_hotels_listing.visibility = View.GONE
        }
    }

    override fun setLoading(loading: Boolean) {
        if (mLoading == loading) return
        if (loading) {
            showLoading(true)
        } else {
            showLoading(false)
        }
        mLoading = loading
    }

    override fun handleSuccess() {
        showLoading(false)
        showError("")
        showData(true)
    }

    override fun handleError(errMsg: String) {
        showLoading(false)
        showData(false)
        showError(errMsg)
    }

    override fun setHotelItemsAdapter(hotelItemsAdapter: HotelItemsAdapter) {
        rv_hotels_listing.adapter = hotelItemsAdapter
    }

    override fun startDetailsActivity() {
        startActivity(Intent(this, DetailsHotelActivity::class.java))
    }

}