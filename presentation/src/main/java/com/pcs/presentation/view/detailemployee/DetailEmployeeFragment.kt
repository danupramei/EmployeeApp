package com.pcs.presentation.view.detailemployee

import android.os.Bundle
import android.view.View
import com.pcs.presentation.consta.Const
import com.pcs.presentation.databinding.FragmentDetailEmployeeBinding
import com.pcs.presentation.models.EmployeeItemUI
import com.pcs.shared.base.BaseFragment
import com.pcs.shared.extent.clickWithDebounce
import com.pcs.shared.extent.getDataFromPreviousFragment
import com.pcs.shared.extent.loadNetworkImage
import com.pcs.shared.extent.onBackPressed
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailEmployeeFragment :
    BaseFragment<FragmentDetailEmployeeBinding>(FragmentDetailEmployeeBinding::inflate) {
    private val employeeUi: EmployeeItemUI by lazy {
        getDataFromPreviousFragment<EmployeeItemUI>(Const.EMPLOYEE_DATA) ?: EmployeeItemUI()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setColorStatusBar(com.pcs.shared.R.color.blue)
        initView()
    }

    private fun initView() = with(binding) {
        ivBtnBack.clickWithDebounce { onBackPressed() }
        ivImgDetailEmployee.loadNetworkImage(employeeUi.avatar)
        tvFirstName.text = employeeUi.firstName
        tvLastName.text = employeeUi.lastName
        tvAddress.text = employeeUi.address
    }
}