package com.tajawa.abdallah.tajawal_android_task.PresentationLayer.Activitys.DetailsHotel

import com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel.DetailsHotelPresenter
import com.tajawa.abdallah.tajawal_android_task.Mocks.DataLayerMocks.RepositorySourceMock
import com.tajawa.abdallah.tajawal_android_task.Mocks.PresentationLayerMocks.ViewsMocks.HotelDetailsViewMock
import org.junit.Test

/**
 * Created by AbdAllah Boda on 26-Mar-18.
 */
class DetailsHotelPresenterTest {

    private val mMockedRepositorySource = RepositorySourceMock()
    private val mPresenterUnderTest = DetailsHotelPresenter(mMockedRepositorySource)

    @Test
    fun setView() {
        mPresenterUnderTest.setView(HotelDetailsViewMock())
        assert(mPresenterUnderTest.mView is HotelDetailsViewMock)
    }

    @Test
    fun removeView() {

    }

    @Test
    fun onGetCurrentSelectedHotelSuccess() {
        val mMockedModel = mMockedRepositorySource.getCurrentSelectedHotel()
        val view = HotelDetailsViewMock()

        mPresenterUnderTest.setView(view)
        mPresenterUnderTest.onGetCurrentSelectedHotelSuccess(mMockedModel)

        assert(view.mImageUrl.equals(mMockedModel.image[0].url))
        assert(view.mAddress.equals(mMockedModel.location.address))
        assert(view.mName.equals(mMockedModel.summary.hotelName))
        assert(view.mLowRate.equals(mMockedModel.summary.lowRate))
        assert(view.mHighRate.equals(mMockedModel.summary.highRate))
    }

}