package com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels

import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter.HotelItemRowView
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter.HotelItemViewHolder
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter.HotelItemsAdapter
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Callbacks
import com.tajawa.abdallah.tajawal_android_task.DataLayer.DataRepository
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelsModel

/**
 * Created by AbdAllah Boda on 23-Mar-18.
 */
class ListingHotelsPresenter(val dataRepository: DataRepository, val view: ListingHotelsContract.View) : ListingHotelsContract.Presenter, HotelItemRowView.HandleOnHotelItemClick {

    private val mDataRepo = dataRepository
    private val mView = view
    private lateinit var mModel: HotelsModel

    override fun start() {
        mView.setLoading(loading = true)
        mDataRepo.getHotels(object : Callbacks.GetHotelsCallbacks {
            override fun onSuccess(result: HotelsModel) {
                onGetHotelsSuccess(hotelsMode = result)
            }

            override fun onError(err: String) {
                onGetHotelsFail(err)
            }
        })
    }

    override fun onGetHotelsSuccess(hotelsMode: HotelsModel) {
        mModel = hotelsMode
        mView.setHotelItemsAdapter(HotelItemsAdapter(presenter = this@ListingHotelsPresenter))
        mView.handleSuccess()
        mView.setLoading(loading = false)
    }

    override fun onGetHotelsFail(err: String) {
        mView.handleError(errMsg = err)
    }

    override fun onBindHotelRowViewAtPosition(holder: HotelItemViewHolder, Position: Int) {
        val sCurrentHotel = mModel.hotel[Position]
        holder.setOnHotelItemClickHandler(this)
        holder.setTitle(sCurrentHotel.summary.hotelName)
        holder.setImage(sCurrentHotel.image[0].url)
    }

    override fun getHotelNumbers(): Int = mModel.hotel.size

    override fun onHotelItemClick(index: Int) {
        mDataRepo.setCurrentSelectedHotel(index)
        mView.startDetailsActivity()
    }
}