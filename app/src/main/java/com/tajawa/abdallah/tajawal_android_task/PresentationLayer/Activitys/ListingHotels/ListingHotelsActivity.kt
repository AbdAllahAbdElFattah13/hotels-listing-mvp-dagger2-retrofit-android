package com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel.DetailsHotelActivity
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter.HotelItemsAdapter
import com.tajawa.abdallah.tajawal_android_task.R
import com.tajawa.abdallah.tajawal_android_task.TajawalApp
import kotlinx.android.synthetic.main.activity_listing_hotels.*
import kotlinx.android.synthetic.main.error_view.*
import kotlinx.android.synthetic.main.loading_view.*
import javax.inject.Inject

class ListingHotelsActivity : AppCompatActivity(), ListingHotelsContract.View {

    private var mLoading: Boolean = false
    private var mComingBackFromChild: Boolean = false
    private val mRequestCodeToDetectedIfComingBackFromChildActivity = 1

    @Inject
    lateinit var mPresenter: ListingHotelsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listing_hotels)

        (application as TajawalApp).mTajawalComponent.inject(this)

        val li = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val dividerItemDecoration = DividerItemDecoration(this, li.orientation)
        rv_hotels_listing.layoutManager = li
        rv_hotels_listing.setHasFixedSize(true)

        progress_view.color = ContextCompat.getColor(this, R.color.colorLoading)

        (application as TajawalApp).mTajawalComponent.inject(this)
    }

    override fun onResume() {
        super.onResume()
        if (!mComingBackFromChild) mPresenter.setView(this)
    }

    override fun onPause() {
        super.onPause()
        mComingBackFromChild = false
        mPresenter.removeView()
    }

    override fun setLoading(loading: Boolean) {
        if (mLoading == loading) return

        val dataVisibility = !loading
        rv_hotels_listing.visibility = if (dataVisibility) View.VISIBLE else View.GONE
        loading_view.visibility = if (loading) View.VISIBLE else View.GONE

        mLoading = loading
    }

    override fun setError(errMsg: String) {
        if (errMsg.isEmpty()) {
            error_view.visibility = View.GONE
        } else {
            error_view.visibility = View.VISIBLE
            tv_error_msg.text = errMsg
        }
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
        if (requestCode == mRequestCodeToDetectedIfComingBackFromChildActivity
                && resultCode == Activity.RESULT_CANCELED)
            mComingBackFromChild = true
    }

}