package com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel.DetailsHotelActivity
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter.HotelItemsAdapter
import com.tajawa.abdallah.tajawal_android_task.BasePresenter
import com.tajawa.abdallah.tajawal_android_task.DataLayer.DataRepository
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Volley.RemoteDataSourceUsingVolley
import com.tajawa.abdallah.tajawal_android_task.R
import kotlinx.android.synthetic.main.activity_listing_hotels.*
import kotlinx.android.synthetic.main.error_view.*
import kotlinx.android.synthetic.main.loading_view.*

class ListingHotelsActivity : AppCompatActivity(), ListingHotelsContract.View {

    private var mLoading: Boolean = false
    private var mComingBackFromChild: Boolean = false
    private val mRequestCodeToDetectedIfComingBackFromChildActivity = 1

    private lateinit var mPresenter: BasePresenter

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listing_hotels)

        val li = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, li.orientation)
        rv_hotels_listing.layoutManager = li
        rv_hotels_listing.setHasFixedSize(true)
        rv_hotels_listing.addItemDecoration(dividerItemDecoration)

        progress_view.color = ContextCompat.getColor(this, R.color.colorLoading)

        //Injecting Dependencies
        mPresenter = ListingHotelsPresenter(
                DataRepository.getInstance(
                        RemoteDataSourceUsingVolley.getInstance(this)
                ), this)
    }

    override fun onResume() {
        super.onResume()
        if (!mComingBackFromChild) mPresenter.start()
    }

    override fun onPause() {
        super.onPause()
        mComingBackFromChild = false
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
        mComingBackFromChild = false
        startActivityForResult(Intent(this, DetailsHotelActivity::class.java), mRequestCodeToDetectedIfComingBackFromChildActivity)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == mRequestCodeToDetectedIfComingBackFromChildActivity && resultCode == Activity.RESULT_CANCELED)
            mComingBackFromChild = true
    }

}