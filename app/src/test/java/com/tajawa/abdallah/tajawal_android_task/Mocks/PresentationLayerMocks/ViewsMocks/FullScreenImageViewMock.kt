package com.tajawa.abdallah.tajawal_android_task.Mocks.PresentationLayerMocks.ViewsMocks

import com.tajawa.abdallah.tajawal_android_task.PresentationLayer.Activitys.FullScreenImage.FullScreenImageContract

/**
 * Created by AbdAllah Boda on 27-Mar-18.
 */
class FullScreenImageViewMock : FullScreenImageContract.View {

    var mUrl = ""
    var finished = false

    override fun setImageUrl(url: String) {
        mUrl = url
    }

    override fun finishView() {
        finished = true
    }
}