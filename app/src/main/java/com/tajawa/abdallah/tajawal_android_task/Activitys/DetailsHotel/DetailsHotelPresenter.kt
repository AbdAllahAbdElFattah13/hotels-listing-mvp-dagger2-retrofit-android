package com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelModel
import com.tajawa.abdallah.tajawal_android_task.DataLayer.RepositorySource

/**
 * Created by AbdAllah Abd-El-Fattah on 23-Mar-18.
 */
class DetailsHotelPresenter(val repositorySource: RepositorySource, val view: DetailsHotelContract.View) : DetailsHotelContract.Presenter {

    private val mDataRepo = repositorySource
    private val mView = view
    private lateinit var mModel: HotelModel

    override fun start() {
        mModel = mDataRepo.getCurrentSelectedHotel()
        onGetCurrentSelectedHotelSuccess(mModel)
    }

    override fun onGetCurrentSelectedHotelSuccess(currentHotel: HotelModel) {
        mView.setImageUrl(currentHotel.image[0].url)
        mView.setHotelName(currentHotel.summary.hotelName)
        mView.setHotelAddress(currentHotel.location.address)
        mView.setLowRate(currentHotel.summary.lowRate.toString())
        mView.setHighRate(currentHotel.summary.highRate.toString())

    }
}