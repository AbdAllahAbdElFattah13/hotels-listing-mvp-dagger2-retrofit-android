package com.tajawa.abdallah.tajawal_android_task.PresentationLayer.Activitys.FullScreenImage

import com.tajawa.abdallah.tajawal_android_task.PresentationLayer.BasePresenter

/**
 * Created by AbdAllah Boda on 27-Mar-18.
 */
interface FullScreenImageContract {
    interface View {
        fun setImageUrl(url: String)

        fun finishView()
    }

    interface Presenter : BasePresenter<View> {
        //in the spirit of MVP, all actions happens in the view
        //should be passed to presenter, even the small ones.
        fun onImageClick()
    }
}