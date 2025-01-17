package com.pcs.data.service

import com.pcs.data.models.EmployeeItemResponse
import retrofit2.Response
import retrofit2.http.GET

interface EmployeeServices {
    @GET("getData/test")
    suspend fun getEmployee(): Response<List<EmployeeItemResponse>>
}