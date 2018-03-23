package com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel

import android.util.Log
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelModel
import com.tajawa.abdallah.tajawal_android_task.DataLayer.RepositorySource

/**
 * Created by AbdAllah Boda on 23-Mar-18.
 */
class DetailsHotelPresenter(val repositorySource: RepositorySource, val view: DetailsHotelContract.View) : DetailsHotelContract.Presenter {

    private val mDataRepo = repositorySource
    private val mView = view
    private lateinit var mModel: HotelModel

    override fun start() {
        mModel = mDataRepo.getCurrentSelectedHotel()
        Log.d("Boda", mModel.toString())
        mView.setImageUrl(mModel.image[0].url)
        mView.setHotelName(mModel.summary.hotelName)
        mView.setHotelAddress(mModel.location.address)
        mView.setLowRate(mModel.summary.lowRate.toString())
        mView.setHighRate(mModel.summary.highRate.toString())
    }
}