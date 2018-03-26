package com.tajawa.abdallah.tajawal_android_task.DI

import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.ListingHotelsContract
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.ListingHotelsPresenter
import com.tajawa.abdallah.tajawal_android_task.DataLayer.RepositorySource
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
}