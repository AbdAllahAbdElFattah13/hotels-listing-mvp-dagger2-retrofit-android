package com.tajawa.abdallah.tajawal_android_task.DataLayer

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelModel
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelsModel
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.RemoteDataSource
import javax.inject.Inject

/**
 * Created by AbdAllah Abd-El-Fattah on 23-Mar-18.
 */
class DataRepository @Inject constructor(private val mRemoteDataSource: RemoteDataSource) : RepositorySource {

    private var mHotelsModel: HotelsModel? = null
    private var mCurrentSelectedHotelIndex: Int = -1
    private lateinit var mCurrentHotelImageUrl: String

    override fun getHotels(callbacks: Callbacks.GetHotelsCallbacks) {
        mRemoteDataSource.getHotels(object : Callbacks.GetHotelsCallbacks {
            override fun onSuccess(result: HotelsModel) {
                mHotelsModel = result
                callbacks.onSuccess(result)
            }

            override fun onError(err: String) {
                callbacks.onError(err)
            }
        })
    }

    override fun setCurrentSelectedHotel(currentSelectedHotelIndex: Int) {
        if (mHotelsModel == null)
            throw IllegalArgumentException("HotelsModel has not been init yet!")

        if (currentSelectedHotelIndex < -1 || currentSelectedHotelIndex > mHotelsModel!!.hotel.size)
            throw IllegalArgumentException("currentSelectedHotelIndex should be within [0, ${mHotelsModel!!.hotel.size})")

        mCurrentSelectedHotelIndex = currentSelectedHotelIndex;
    }

    override fun getCurrentSelectedHotel(): HotelModel {

        if (mHotelsModel == null)
            throw IllegalArgumentException("HotelsModel has not been init yet!")
        if (mCurrentSelectedHotelIndex == -1)
            throw IllegalArgumentException("Calling getCurrentSelectedHotel before setting the selected Hotel")

        return mHotelsModel!!.hotel[mCurrentSelectedHotelIndex]
    }

    override fun setCurrentHotelImageUrl(imageUrl: String) {
        if (imageUrl.trim().isEmpty()) throw  IllegalArgumentException("Illegal string for image url")
        mCurrentHotelImageUrl = imageUrl
    }

    override fun getCurrentHotelImageUrl(): String = mCurrentHotelImageUrl
}