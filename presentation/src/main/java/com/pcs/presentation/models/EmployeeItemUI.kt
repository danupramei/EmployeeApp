package com.pcs.presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EmployeeItemUI(
    val id: String = "",
    val avatar: String = "",
    val address: String = "",
    val dob: String = "",
    val fullName: String = "",
    val firstName: String = "",
    val lastName: String = ""
): Parcelable