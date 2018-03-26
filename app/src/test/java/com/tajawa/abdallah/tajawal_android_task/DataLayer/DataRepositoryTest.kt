package com.tajawa.abdallah.tajawal_android_task.DataLayer

import android.test.mock.MockContext
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelsModel
import com.tajawa.abdallah.tajawal_android_task.Mocks.DataLayerMocks.ModelsMocks.HotelsModelMock
import com.tajawa.abdallah.tajawal_android_task.Mocks.DataLayerMocks.RemoteDataSourceMock
import org.junit.Before
import org.junit.Test

/**
 * Created by AbdAllah Abd-El-Fattah on 24-Mar-18.
 */
class DataRepositoryTest {

    private val mMockedRemoteDataSource = RemoteDataSourceMock.getInstance(MockContext())
    private lateinit var mDateRepositoryUnderTesting: RepositorySource

    @Before
    fun initRepoUnderTesting() {
        mDateRepositoryUnderTesting = DataRepository(mMockedRemoteDataSource)
    }

    @Test(expected = IllegalArgumentException::class)
    fun setCurrentSelectedHotelBeforeSettingTheModel() {
        mDateRepositoryUnderTesting.setCurrentSelectedHotel(0);
    }

    @Test(expected = IllegalArgumentException::class)
    fun getCurrentSelectedHotelBeforeSettingTheModel() {
        mDateRepositoryUnderTesting.getCurrentSelectedHotel()
    }

    @Test
    fun getHotelsFail() {
        mMockedRemoteDataSource.setSuccess(false)
        mDateRepositoryUnderTesting.getHotels(object : Callbacks.GetHotelsCallbacks {
            override fun onSuccess(result: HotelsModel) {
                assert(false)
            }

            override fun onError(err: String) {
                assert(!err.isEmpty())
            }

        })

    }

    @Test
    fun getHotelsSuccess() {
        mMockedRemoteDataSource.setSuccess(true)
        mDateRepositoryUnderTesting.getHotels(object : Callbacks.GetHotelsCallbacks {
            override fun onSuccess(result: HotelsModel) {
                assert(!result.hotel.isEmpty() && result.hotel.equals(mMockedRemoteDataSource.mockedModel))
            }

            override fun onError(err: String) {
                assert(false)
            }
        })
    }

    @Test
    fun getHotelsHappyPath() {
        mMockedRemoteDataSource.setSuccess(true)
        mDateRepositoryUnderTesting.getHotels(object : Callbacks.GetHotelsCallbacks {
            override fun onSuccess(result: HotelsModel) {
                mDateRepositoryUnderTesting.setCurrentSelectedHotel(0)

                assert(mDateRepositoryUnderTesting.getCurrentSelectedHotel().equals(mMockedRemoteDataSource.mockedModel.hotel[0]))
            }

            override fun onError(err: String) {
                assert(false)
            }

        })
    }

    @Test(expected = IllegalArgumentException::class)
    fun setCurrentHotelImageUrlWithEmpty() {
        mDateRepositoryUnderTesting.setCurrentHotelImageUrl("");
    }

    @Test(expected = IllegalArgumentException::class)
    fun getCurrentHotelImageUrlBeforeSettingIt() {
        val mDateRepositoryUnderTesting = DataRepository(mMockedRemoteDataSource)
        mDateRepositoryUnderTesting.getCurrentSelectedHotel()
    }

    @Test
    fun getCurrentHotelImageUrlHappyPath() {
        val expected = HotelsModelMock.getHotels().hotel[0].image[0].url

        mDateRepositoryUnderTesting.setCurrentHotelImageUrl(expected)
        assert(expected.equals(mDateRepositoryUnderTesting.getCurrentHotelImageUrl()))
    }

}