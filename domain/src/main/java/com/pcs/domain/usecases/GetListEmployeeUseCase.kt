package com.pcs.domain.usecases

import com.pcs.domain.models.EmployeeItemDomain
import com.pcs.domain.repository.EmployeeRepository
import com.pcs.domain.utils.DomainResult
import javax.inject.Inject

class GetListEmployeeUseCase @Inject constructor(
    private val employeeRepository: EmployeeRepository
) {
    suspend operator fun invoke(): DomainResult<List<EmployeeItemDomain>> {
        return employeeRepository.getListEmployee()
    }
}