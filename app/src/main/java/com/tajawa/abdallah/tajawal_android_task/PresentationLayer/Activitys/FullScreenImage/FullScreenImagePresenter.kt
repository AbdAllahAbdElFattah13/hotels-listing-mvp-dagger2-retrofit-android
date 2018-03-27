package com.tajawa.abdallah.tajawal_android_task.PresentationLayer.Activitys.FullScreenImage

import com.tajawa.abdallah.tajawal_android_task.DataLayer.RepositorySource
import javax.inject.Inject

/**
 * Created by AbdAllah Boda on 27-Mar-18.
 */
class FullScreenImagePresenter @Inject constructor(private val mRepositorySource: RepositorySource) : FullScreenImageContract.Presenter {

    var mView: FullScreenImageContract.View? = null

    override fun setView(view: FullScreenImageContract.View) {
        mView = view
        mView!!.setImageUrl(mRepositorySource.getCurrentHotelImageUrl())
    }

    override fun removeView() {
        mView = null
    }

    override fun onImageClick() {
        if (mView == null)
            throw IllegalStateException("Calling with onImageClick with mView = null. (i.e: before calling setView")
        mView!!.finishView()
    }
}