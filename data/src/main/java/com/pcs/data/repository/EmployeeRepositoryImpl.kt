package com.pcs.data.repository

import com.pcs.data.mapper.toListDomain
import com.pcs.data.network.processResponseSuspended
import com.pcs.data.service.EmployeeServices
import com.pcs.domain.models.EmployeeItemDomain
import com.pcs.domain.repository.EmployeeRepository
import com.pcs.domain.utils.DomainResult
import javax.inject.Inject

class EmployeeRepositoryImpl @Inject constructor(
    private val employeeServices: EmployeeServices
) : EmployeeRepository {
    override suspend fun getListEmployee(): DomainResult<List<EmployeeItemDomain>> {
        val result = employeeServices.getEmployee()
        return processResponseSuspended(result) {
            DomainResult.Success(it.toListDomain())
        }
    }
}