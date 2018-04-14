package com.tajawa.abdallah.tajawal_android_task.DI.Modules

import com.tajawa.abdallah.tajawal_android_task.DataLayer.DataRepository
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.RemoteDataSource
import com.tajawa.abdallah.tajawal_android_task.DataLayer.RepositorySource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by AbdAllah Boda on 25-Mar-18.
 */
@Module
class RepositorySourceModule {
    @Provides
    @Singleton
    fun provideRepositorySource(remoteDataSource: RemoteDataSource): RepositorySource = DataRepository(remoteDataSource)
}