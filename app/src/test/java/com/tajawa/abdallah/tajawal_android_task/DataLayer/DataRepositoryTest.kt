package com.tajawa.abdallah.tajawal_android_task.DataLayer

import android.test.mock.MockContext
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Mocks.RemoteDataSourceMock
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelsModel
import org.junit.Test

/**
 * Created by AbdAllah Boda on 24-Mar-18.
 */
class DataRepositoryTest {

    private val mMockedRemoteDataSource = RemoteDataSourceMock.getInstance(MockContext())

    @Test(expected = IllegalArgumentException::class)
    fun setCurrentSelectedHotelBeforeSettingTheModel() {
        val mDateRepositoryUnderTesting = DataRepository.getInstance(mMockedRemoteDataSource)
        mDateRepositoryUnderTesting.setCurrentSelectedHotel(0);
    }

    @Test(expected = IllegalArgumentException::class)
    fun getCurrentSelectedHotelBeforeSettingTheModel() {
        val mDateRepositoryUnderTesting = DataRepository.getInstance(mMockedRemoteDataSource)
        mDateRepositoryUnderTesting.getCurrentSelectedHotel()
    }

    @Test
    fun getHotelsFail() {
        mMockedRemoteDataSource.setSuccess(false)
        val mDateRepositoryUnderTesting = DataRepository.getInstance(mMockedRemoteDataSource)
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
        val mDataRepositoryUnderTest = DataRepository.getInstance(mMockedRemoteDataSource)
        mDataRepositoryUnderTest.getHotels(object : Callbacks.GetHotelsCallbacks {
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
        val mDataRepositoryUnderTest = DataRepository.getInstance(mMockedRemoteDataSource)
        mDataRepositoryUnderTest.getHotels(object : Callbacks.GetHotelsCallbacks {
            override fun onSuccess(result: HotelsModel) {
                mDataRepositoryUnderTest.setCurrentSelectedHotel(0)

                assert(mDataRepositoryUnderTest.getCurrentSelectedHotel().equals(mMockedRemoteDataSource.mockedModel.hotel[0]))
            }

            override fun onError(err: String) {
                assert(false)
            }

        })
    }
}