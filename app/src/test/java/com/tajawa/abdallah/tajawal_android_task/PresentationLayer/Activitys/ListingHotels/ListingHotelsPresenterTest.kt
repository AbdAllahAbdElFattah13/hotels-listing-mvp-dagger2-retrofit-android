package com.tajawa.abdallah.tajawal_android_task.PresentationLayer.Activitys.ListingHotels

import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.ListingHotelsPresenter
import com.tajawa.abdallah.tajawal_android_task.Mocks.DataLayerMocks.RepositorySourceMock
import com.tajawa.abdallah.tajawal_android_task.Mocks.PresentationLayerMocks.ViewsMocks.HotelRowViewMock
import com.tajawa.abdallah.tajawal_android_task.Mocks.PresentationLayerMocks.ViewsMocks.HotelsListingActivityMock
import org.junit.Before
import org.junit.Test

/**
 * Created by AbdAllah Boda on 27-Mar-18.
 */
class ListingHotelsPresenterTest {

    val mRepositorySourceMock = RepositorySourceMock()
    lateinit var mViewMock: HotelsListingActivityMock

    lateinit var mPresenterUnderTest: ListingHotelsPresenter

    @Before
    fun initPresenter() {
        mPresenterUnderTest = ListingHotelsPresenter(RepositorySourceMock())
        mViewMock = HotelsListingActivityMock()
        mPresenterUnderTest.setView(mViewMock)
    }

    @Test
    fun setView() {
        mPresenterUnderTest.setView(mViewMock)
        assert(mPresenterUnderTest.mView is HotelsListingActivityMock)
    }

    @Test
    fun onGetHotelsSuccess() {
        mPresenterUnderTest.onGetHotelsSuccess(mRepositorySourceMock.mMockedModel)
        //set view will call getHotelsSuccess internally, which will first set the model
        assert(mPresenterUnderTest.mModel.equals(mRepositorySourceMock.mMockedModel))
        //then stop the loading..
        assert(!mViewMock.mLoading)
        //and delete any error msgs
        assert(mViewMock.mError.isEmpty())
        //and the adapter should be init as well
        assert(mViewMock.mHotelItemsAdapter != null)
    }

    @Test
    fun onGetHotelsFail() {
        val errMsg = "Failed"
        mPresenterUnderTest.onGetHotelsFail(errMsg)

        //view should stop loading..
        assert(!mViewMock.mLoading)
        //and should get the error msg
        assert(errMsg.equals(mViewMock.mError))
    }

    @Test
    fun onBindHotelRowViewAtPosition() {
        val sHotelRowViewMock = HotelRowViewMock()
        //setting the model to test binding view holder
        mPresenterUnderTest.mModel = mRepositorySourceMock.mMockedModel

        mPresenterUnderTest.onBindHotelRowViewAtPosition(sHotelRowViewMock, 0)

        //the onClick event listener should be init, and should be the presenter it self
        assert(sHotelRowViewMock.mOnItemRowClick != null
                && sHotelRowViewMock.mOnItemRowClick!!.equals(mPresenterUnderTest))
        //title of the view holder has been set by the hotel name..
        assert(sHotelRowViewMock.mTitle.equals(mRepositorySourceMock.mMockedModel.hotel[0].summary.hotelName))
        //and the url has been set equal to the first image url
        assert(sHotelRowViewMock.mUrl.equals(mRepositorySourceMock.mMockedModel.hotel[0].image[0].url))

    }

    @Test
    fun getHotelNumbers() {
        val expected = mRepositorySourceMock.mMockedModel.hotel.size
        val found = mPresenterUnderTest.getHotelNumbers()

        assert(expected == found)
    }

    @Test
    fun onHotelItemClick() {
        val expectedIndex = 7
        mPresenterUnderTest.onHotelItemClick(expectedIndex)
        val foundIndex = mRepositorySourceMock.mMockedCurrentSelectedHotel

        assert(expectedIndex == foundIndex)
    }

}