package com.tajawa.abdallah.tajawal_android_task.PresentationLayer.Activitys.FullScreenImage

import com.tajawa.abdallah.tajawal_android_task.PresentationLayer.BasePresenter

/**
 * Created by AbdAllah Boda on 27-Mar-18.
 */
interface FullScreenImageContract {
    interface View {
        fun setImageUrl(url: String)
    }

    interface Presenter : BasePresenter<View>
}