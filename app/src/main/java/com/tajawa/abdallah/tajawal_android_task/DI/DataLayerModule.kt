package com.tajawa.abdallah.tajawal_android_task.DI

import android.content.Context
import com.tajawa.abdallah.tajawal_android_task.DataLayer.DataRepository
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.RemoteDataSource
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Volley.RemoteDataSourceUsingVolley
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Volley.VolleyImplementation
import com.tajawa.abdallah.tajawal_android_task.DataLayer.RepositorySource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by AbdAllah Boda on 25-Mar-18.
 */
@Module
class DataLayerModule {
    @Provides
    @Singleton
    fun provideVolleyImplementation(context: Context): VolleyImplementation = VolleyImplementation(context)

    @Provides
    @Singleton
    fun provideRemoteDataSource(volley: VolleyImplementation): RemoteDataSource = RemoteDataSourceUsingVolley(volley)

    @Provides
    @Singleton
    fun provideRepositorySource(remoteDataSource: RemoteDataSource): RepositorySource = DataRepository(remoteDataSource)
}