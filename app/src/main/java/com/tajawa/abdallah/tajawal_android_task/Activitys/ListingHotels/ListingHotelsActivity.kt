package com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel.DetailsHotelActivity
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter.HotelItemsAdapter
import com.tajawa.abdallah.tajawal_android_task.DataLayer.DataRepository
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Volley.RemoteDataSourceUsingVolley
import com.tajawa.abdallah.tajawal_android_task.R
import kotlinx.android.synthetic.main.activity_listing_hotels.*

class ListingHotelsActivity : AppCompatActivity(), ListingHotelsContract.View {


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

    private fun showData(show: Boolean) {
        if (show) {

        } else {
        }
    }

    override fun setLoading(loading: Boolean) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleError(errMsg: String) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setHotelItemsAdapter(hotelItemsAdapter: HotelItemsAdapter) {
        rv_hotels_listing.adapter = hotelItemsAdapter
    }

    override fun startDetailsActivity() {
        startActivity(Intent(this, DetailsHotelActivity::class.java))
    }

}