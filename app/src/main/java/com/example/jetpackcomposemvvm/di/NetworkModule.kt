package com.example.jetpackcomposemvvm.di

import com.example.jetpackcomposemvvm.app.TweetsyConstants
import com.example.jetpackcomposemvvm.data.api.TweetsyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(TweetsyConstants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesTweetsyApi(retrofit: Retrofit) : TweetsyApi {
        return retrofit.create(TweetsyApi::class.java)
    }
}