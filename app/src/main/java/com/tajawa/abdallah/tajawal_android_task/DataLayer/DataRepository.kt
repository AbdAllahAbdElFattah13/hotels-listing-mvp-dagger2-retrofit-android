package com.tajawa.abdallah.tajawal_android_task.DataLayer

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelModel
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelsModel
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.RemoteDataSource

/**
 * Created by AbdAllah Boda on 23-Mar-18.
 */
class DataRepository private constructor(remoteDataSource: RemoteDataSource) : RepositorySource {

    private val mRemoteDataSource: RemoteDataSource = remoteDataSource

    private lateinit var mHotelsModel: HotelsModel
    private var mCurrentSelectedHotelIndex: Int = -1

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
        mCurrentSelectedHotelIndex = currentSelectedHotelIndex;
    }

    override fun getCurrentSelectedHotel(): HotelModel = mHotelsModel.hotel[mCurrentSelectedHotelIndex]

    companion object {
        private var INSTANCE: DataRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): DataRepository {
            if (INSTANCE == null)
                INSTANCE = DataRepository(remoteDataSource)
            return INSTANCE!!
        }
    }
}