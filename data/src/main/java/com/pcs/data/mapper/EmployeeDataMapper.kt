package com.pcs.data.mapper

import com.pcs.data.models.EmployeeItemResponse
import com.pcs.domain.models.EmployeeItemDomain

fun List<EmployeeItemResponse>?.toListDomain(): List<EmployeeItemDomain> =
    this.orEmpty().map { it.toDomainModel() }

fun EmployeeItemResponse?.toDomainModel(): EmployeeItemDomain = this?.run {
    EmployeeItemDomain(
        addressNo = addressNo.orEmpty(),
        avatar = avatar.orEmpty(),
        city = city.orEmpty(),
        country = country.orEmpty(),
        county = county.orEmpty(),
        createdAt = createdAt.orEmpty(),
        id = id.orEmpty(),
        name = name.orEmpty(),
        street = street.orEmpty(),
        zipCode = zipCode.orEmpty()
    )
} ?: EmployeeItemDomain()