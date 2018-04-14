package com.tajawa.abdallah.tajawal_android_task.DI.Modules.RemoteDataSourceModules

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.RemoteDataSource
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Volley.RemoteDataSourceUsingVolley
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Volley.VolleyImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataSourceModule {
    @Provides
    @Singleton
    fun provideRemoteDataSource(volley: VolleyImplementation): RemoteDataSource = RemoteDataSourceUsingVolley(volley)
}