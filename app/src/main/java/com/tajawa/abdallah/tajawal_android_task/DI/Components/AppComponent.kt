package com.tajawa.abdallah.tajawal_android_task.DI.Components

import com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel.DetailsHotelActivity
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.ListingHotelsActivity
import com.tajawa.abdallah.tajawal_android_task.DI.Modules.ContextModule
import com.tajawa.abdallah.tajawal_android_task.DI.Modules.PresenterModule
import com.tajawa.abdallah.tajawal_android_task.DI.Modules.RemoteDataSourceModules.RemoteDataSourceModule
import com.tajawa.abdallah.tajawal_android_task.DI.Modules.RemoteDataSourceModules.RetrofitModules.RetrofitModule
import com.tajawa.abdallah.tajawal_android_task.DI.Modules.RemoteDataSourceModules.RetrofitModules.RetrofitServicesModule
import com.tajawa.abdallah.tajawal_android_task.DI.Modules.RemoteDataSourceModules.VolleyModule
import com.tajawa.abdallah.tajawal_android_task.DI.Modules.RepositorySourceModule
import com.tajawa.abdallah.tajawal_android_task.PresentationLayer.Activitys.FullScreenImage.FullScreenImageActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by AbdAllah Boda on 25-Mar-18.
 */
@Singleton
@Component(modules = [ContextModule::class, VolleyModule::class, RetrofitModule::class, RetrofitServicesModule::class,
    RemoteDataSourceModule::class, RepositorySourceModule::class, PresenterModule::class])
interface AppComponent {

    fun inject(target: ListingHotelsActivity)

    fun inject(target: DetailsHotelActivity)

    fun inject(target: FullScreenImageActivity)
}