package com.tajawa.abdallah.tajawal_android_task.DataLayer.Mocks

import android.content.Context
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Callbacks
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.*
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.RemoteDataSource

/**
 * Created by AbdAllah Abd-El-Fattah on 24-Mar-18.
 */
/**
 * Mock up data to allow DataRepo to be tested.
 */
class RemoteDataSourceMock private constructor(context: Context) : RemoteDataSource {

    private var willSuccess: Boolean = true

    val mockedModel: HotelsModel = HotelsModel(listOf(HotelModel(
            SummaryModel(
                    highRate = 6386.04,
                    hotelName = "Coral Oriental Dubai",
                    lowRate = 4958.58),
            image = listOf(ImageModel("https://az712897.vo.msecnd.net/images/full/A1EE945E-166C-4AC0-BB73-00B1D8F5DEF0.jpeg")),
            location = LocationModel(
                    address = "Burj Nahar Roundabout, Naif Road,",
                    latitude = 25.275914,
                    longitude = 55.313262), hotelId = 4020979
    )))


    fun setSuccess(success: Boolean) {
        this.willSuccess = success
    }

    override fun getHotels(callbacks: Callbacks.GetHotelsCallbacks) {
        Thread.sleep(1000);
        if (willSuccess)
            callbacks.onSuccess(mockedModel)
        else
            callbacks.onError("Network Error")
    }

    companion object {
        private var INSTANCE: RemoteDataSourceMock? = null

        fun getInstance(context: Context): RemoteDataSourceMock {
            if (INSTANCE == null)
                INSTANCE = RemoteDataSourceMock(context)
            return INSTANCE!!
        }
    }
}