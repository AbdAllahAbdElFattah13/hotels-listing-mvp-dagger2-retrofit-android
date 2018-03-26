package com.tajawa.abdallah.tajawal_android_task.DI

import com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel.DetailsHotelContract
import com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel.DetailsHotelPresenter
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.ListingHotelsContract
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.ListingHotelsPresenter
import com.tajawa.abdallah.tajawal_android_task.DataLayer.RepositorySource
import com.tajawa.abdallah.tajawal_android_task.PresentationLayer.Activitys.FullScreenImage.FullScreenImageContract
import com.tajawa.abdallah.tajawal_android_task.PresentationLayer.Activitys.FullScreenImage.FullScreenImagePresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by AbdAllah Boda on 25-Mar-18.
 */
@Module
class PresenterModule {
    @Provides
    @Singleton
    fun provideListingHotelsPresenter(repositorySource: RepositorySource): ListingHotelsContract.Presenter = ListingHotelsPresenter(repositorySource)

    @Provides
    @Singleton
    fun provideDetailsHotelPresenter(repositorySource: RepositorySource): DetailsHotelContract.Presenter = DetailsHotelPresenter(repositorySource)

    @Provides
    @Singleton
    fun provideFullScreenImagePresenter(repositorySource: RepositorySource): FullScreenImageContract.Presenter = FullScreenImagePresenter(repositorySource)

}