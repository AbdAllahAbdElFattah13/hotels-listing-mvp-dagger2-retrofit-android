package com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelModel
import com.tajawa.abdallah.tajawal_android_task.DataLayer.RepositorySource
import javax.inject.Inject

/**
 * Created by AbdAllah Abd-El-Fattah on 23-Mar-18.
 */
class DetailsHotelPresenter @Inject constructor(private val mDataRepo: RepositorySource) : DetailsHotelContract.Presenter {

    private lateinit var mView: DetailsHotelContract.View
    private lateinit var mModel: HotelModel

    override fun setView(view: DetailsHotelContract.View) {
        mView = view
        mModel = mDataRepo.getCurrentSelectedHotel()
        onGetCurrentSelectedHotelSuccess(mModel)
    }

    override fun removeView() {
        //to do any clearing up required
    }

    override fun onGetCurrentSelectedHotelSuccess(currentHotel: HotelModel) {
        mView.setImageUrl(currentHotel.image[0].url)
        mView.setHotelName(currentHotel.summary.hotelName)
        mView.setHotelAddress(currentHotel.location.address)
        mView.setLowRate(currentHotel.summary.lowRate.toString())
        mView.setHighRate(currentHotel.summary.highRate.toString())

    }
}