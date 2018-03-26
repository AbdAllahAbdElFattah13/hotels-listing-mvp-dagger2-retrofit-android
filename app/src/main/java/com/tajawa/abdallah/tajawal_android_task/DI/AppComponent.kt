package com.tajawa.abdallah.tajawal_android_task.DI

import com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel.DetailsHotelActivity
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.ListingHotelsActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by AbdAllah Boda on 25-Mar-18.
 */
@Singleton
@Component(modules = [ContextModule::class, DataLayerModule::class, PresenterModule::class])
interface AppComponent {
    fun inject(target: ListingHotelsActivity)

    fun inject(target: DetailsHotelActivity)
}