package com.tajawa.abdallah.tajawal_android_task.DataLayer.Mocks.DataLayerMocks

import android.content.Context
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Callbacks
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Mocks.DataLayerMocks.ModelsMocks.HotelsModelMock
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.RemoteDataSource

/**
 * Created by AbdAllah Abd-El-Fattah on 24-Mar-18.
 */
/**
 * Mock up data to allow DataRepo to be tested.
 */
class RemoteDataSourceMock private constructor(context: Context) : RemoteDataSource {

    private var willSuccess: Boolean = true

    val mockedModel = HotelsModelMock.getHotels()


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