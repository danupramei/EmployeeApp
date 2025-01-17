package com.pcs.domain.repository

import com.pcs.domain.models.EmployeeItemDomain
import com.pcs.domain.utils.DomainResult

interface EmployeeRepository {
    suspend fun getListEmployee(): DomainResult<List<EmployeeItemDomain>>
}