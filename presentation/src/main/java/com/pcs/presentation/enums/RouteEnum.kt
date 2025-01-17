package com.pcs.presentation.enums

import androidx.fragment.app.Fragment
import com.pcs.presentation.R

enum class RouteEnum(private val routeResId: Int) {
    DETAIL_EMPLOYEE(R.string.detail_employee_route);

    fun getRouteName(fragment: Fragment): String = fragment.getString(routeResId)
}