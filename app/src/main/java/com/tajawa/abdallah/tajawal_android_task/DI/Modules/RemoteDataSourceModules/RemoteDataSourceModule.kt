package com.tajawa.abdallah.tajawal_android_task.DI.Modules.RemoteDataSourceModules

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.RemoteDataSource
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Retrofit.RemoteDataSourceUsingRetrofit
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Retrofit.Services.HotelsServices
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Volley.RemoteDataSourceUsingVolley
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Volley.VolleyImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class RemoteDataSourceModule {

    @Named("volley")
    @Provides
    @Singleton
    fun provideVolleyRemoteDataSource(volley: VolleyImplementation): RemoteDataSource = RemoteDataSourceUsingVolley(volley)

    @Named("retrofit")
    @Provides
    @Singleton
    fun provideRetrofitRemoteDataSource(hotelsServices: HotelsServices): RemoteDataSource = RemoteDataSourceUsingRetrofit(hotelsServices)
}