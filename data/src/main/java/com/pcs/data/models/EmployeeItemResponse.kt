package com.pcs.data.models
import com.google.gson.annotations.SerializedName

data class EmployeeItemResponse(
    @SerializedName("address_no")
    val addressNo: String? = null,
    @SerializedName("avatar")
    val avatar: String? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("county")
    val county: String? = null,
    @SerializedName("createdAt")
    val createdAt: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("street")
    val street: String? = null,
    @SerializedName("zip_code")
    val zipCode: String? = null
)