package com.pcs.employeeapp.di

import com.pcs.data.repository.EmployeeRepositoryImpl
import com.pcs.data.service.EmployeeServices
import com.pcs.domain.repository.EmployeeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideEmployeeRepository(apiService: EmployeeServices): EmployeeRepository {
        return EmployeeRepositoryImpl(apiService)
    }
}