package com.pcs.presentation.mapper

import com.pcs.domain.models.EmployeeItemDomain
import com.pcs.presentation.models.EmployeeItemUI

fun List<EmployeeItemDomain>?.toListUI(): List<EmployeeItemUI> =
    this.orEmpty().map { it.toUiModel() }

fun EmployeeItemDomain?.toUiModel(): EmployeeItemUI = this?.run {
    EmployeeItemUI(
        id = id,
        address = "$addressNo $street $county $zipCode $country",
        avatar = avatar,
        dob = createdAt,
        fullName = name,
        firstName = splitName(name).first,
        lastName = splitName(name).second
    )
} ?: EmployeeItemUI()

private fun splitName(name: String): Pair<String, String> {
    val parts = name.trim().split("\\s+".toRegex())
    val firstName = parts.firstOrNull().orEmpty()
    val lastName = if (parts.size > 1) parts.subList(1, parts.size).joinToString(" ") else ""
    return Pair(firstName, lastName)
}