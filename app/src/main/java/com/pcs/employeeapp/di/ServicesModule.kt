package com.pcs.employeeapp.di

import com.pcs.data.service.EmployeeServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServicesModule {
    @Provides
    @Singleton
    fun provideEmployeeServices(
        retrofitBuilder: Retrofit.Builder,
        okHttpClient: OkHttpClient
    ): EmployeeServices {
        return retrofitBuilder.client(okHttpClient).baseUrl("https://66b197c51ca8ad33d4f482c9.mockapi.io/").build()
            .create(EmployeeServices::class.java)
    }
}