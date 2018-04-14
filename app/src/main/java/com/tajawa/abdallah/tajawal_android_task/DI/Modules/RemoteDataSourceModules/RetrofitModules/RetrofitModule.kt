package com.tajawa.abdallah.tajawal_android_task.DI.Modules.RemoteDataSourceModules.RetrofitModules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.EndPoints
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
class RetrofitModule {

    @Named("base_url")
    @Provides
    @Singleton
    fun provideBaseUrl() = EndPoints.baseURL

    @Provides
    @Singleton
    fun provideGson() = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson) = GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun provideRetrofit(@Named("base_url") baseURL: String, gsonConverterFactory: GsonConverterFactory) = Retrofit.Builder().baseUrl(baseURL).addConverterFactory(gsonConverterFactory).build()
}