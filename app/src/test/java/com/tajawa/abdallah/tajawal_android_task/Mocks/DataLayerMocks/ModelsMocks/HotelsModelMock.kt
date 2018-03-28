package com.tajawa.abdallah.tajawal_android_task.Mocks.DataLayerMocks.ModelsMocks

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.*

/**
 * Created by AbdAllah Boda on 26-Mar-18.
 */
object HotelsModelMock {
    fun getHotels(): HotelsModel = HotelsModel(listOf(HotelModel(
            SummaryModel(
                    highRate = 6386.04,
                    hotelName = "Coral Oriental Dubai",
                    lowRate = 4958.58),
            image = listOf(ImageModel("https://az712897.vo.msecnd.net/images/full/A1EE945E-166C-4AC0-BB73-00B1D8F5DEF0.jpeg")),
            location = LocationModel(
                    address = "Burj Nahar Roundabout, Naif Road,",
                    latitude = 25.275914,
                    longitude = 55.313262), hotelId = 4020979
    )))

    //same object but for the ID, should fail .equals()
    fun getSecondaryHotels(): HotelsModel = HotelsModel(listOf(HotelModel(
            SummaryModel(
                    highRate = 6386.04,
                    hotelName = "Coral Oriental Dubai",
                    lowRate = 4958.58),
            image = listOf(ImageModel("https://az712897.vo.msecnd.net/images/full/A1EE945E-166C-4AC0-BB73-00B1D8F5DEF0.jpeg")),
            location = LocationModel(
                    address = "Burj Nahar Roundabout, Naif Road,",
                    latitude = 25.275914,
                    longitude = 55.313262), hotelId = 4021032
    )))
}