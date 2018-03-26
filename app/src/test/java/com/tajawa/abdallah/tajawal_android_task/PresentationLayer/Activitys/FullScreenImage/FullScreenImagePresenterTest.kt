package com.tajawa.abdallah.tajawal_android_task.PresentationLayer.Activitys.FullScreenImage

import com.tajawa.abdallah.tajawal_android_task.Mocks.DataLayerMocks.RepositorySourceMock
import com.tajawa.abdallah.tajawal_android_task.Mocks.PresentationLayerMocks.ViewsMocks.FullScreenImageViewMock
import org.junit.Test

/**
 * Created by AbdAllah Boda on 27-Mar-18.
 */
class FullScreenImagePresenterTest {

    val mRepositorySourceMock = RepositorySourceMock()
    val mPresenterUnderTesting = FullScreenImagePresenter(mRepositorySourceMock)

    @Test
    fun setView() {
        val view = FullScreenImageViewMock()
        mPresenterUnderTesting.setView(view)
        assert(mPresenterUnderTesting.mView is FullScreenImageViewMock)

        //the presenter will set the url into the view from the passed-in repo.
        assert(view.mUrl.equals(mRepositorySourceMock.getCurrentHotelImageUrl()))
    }

    @Test
    fun removeView() {
        mPresenterUnderTesting.removeView()
        assert(mPresenterUnderTesting.mView == null)
    }

}