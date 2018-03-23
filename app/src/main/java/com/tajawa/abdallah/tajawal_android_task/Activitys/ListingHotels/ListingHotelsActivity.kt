package com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter.HotelItemsAdapter
import com.tajawa.abdallah.tajawal_android_task.DataLayer.DataRepository
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Volley.RemoteDataSourceUsingVolley
import com.tajawa.abdallah.tajawal_android_task.R

class ListingHotelsActivity : AppCompatActivity(), ListingHotelsContract.View {

    private lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listing_hotels)

        mRecyclerView = findViewById<RecyclerView>(R.id.rv_hotels_listing)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
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
        mRecyclerView.adapter = hotelItemsAdapter
    }
}