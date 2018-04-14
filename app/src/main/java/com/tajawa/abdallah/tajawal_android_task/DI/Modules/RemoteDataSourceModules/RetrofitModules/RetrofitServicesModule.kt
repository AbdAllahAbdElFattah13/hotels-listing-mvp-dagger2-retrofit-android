package com.tajawa.abdallah.tajawal_android_task.DI.Modules.RemoteDataSourceModules.RetrofitModules

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Retrofit.Services.HotelsServices
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RetrofitServicesModule {

    @Provides
    @Singleton
    fun provideHotelServices(retrofit: Retrofit): HotelsServices = retrofit.create(HotelsServices::class.java)
}