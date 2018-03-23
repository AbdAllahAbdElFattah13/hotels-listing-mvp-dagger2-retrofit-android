package com.tajawa.abdallah.tajawal_android_task.DataLayer

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelsModel

/**
 * Created by AbdAllah Boda on 23-Mar-18.
 */
interface Callbacks {
    interface BaseNetworkCallbacks<OnSuccessReturnType> {
        fun onSuccess(result: OnSuccessReturnType)
        fun onError(err: String)
    }

    interface GetHotelsCallbacks : BaseNetworkCallbacks<HotelsModel>
}