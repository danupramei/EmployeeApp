package com.pcs.presentation.view.listemployee

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import com.pcs.presentation.adapter.EmployeeAdapter
import com.pcs.presentation.consta.Const
import com.pcs.presentation.databinding.FragmentListEmployeeBinding
import com.pcs.presentation.enums.RouteEnum
import com.pcs.presentation.models.EmployeeItemUI
import com.pcs.presentation.utils.launchAndCollectIn
import com.pcs.presentation.utils.onEmpty
import com.pcs.presentation.utils.onError
import com.pcs.presentation.utils.onSuccess
import com.pcs.shared.base.BaseFragment
import com.pcs.shared.extent.dpToPixels
import com.pcs.shared.extent.gone
import com.pcs.shared.extent.invisible
import com.pcs.shared.extent.navigate
import com.pcs.shared.extent.showToastMessage
import com.pcs.shared.extent.verticalLinearLayoutManager
import com.pcs.shared.extent.visible
import com.pcs.shared.utils.CustomMarginDecoration
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListEmployeeFragment :
    BaseFragment<FragmentListEmployeeBinding>(FragmentListEmployeeBinding::inflate) {
    @Inject
    lateinit var adapterEmployee: EmployeeAdapter

    private val viewModel by viewModels<ListEmployeeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setColorStatusBar(com.pcs.shared.R.color.white)
        viewModel.getListEmployee()
        initView()
        initAdapter()
        observe()
    }

    private fun initView() = with(binding) {
        swipeListEmployee.isRefreshing = true
        swipeListEmployee.setOnRefreshListener {
            viewModel.getListEmployee()
        }
        toolbarEmployeeList.imgBack.invisible()
    }

    private fun observe() = with(binding) {
        viewModel.listEmployee.launchAndCollectIn(
            viewLifecycleOwner,
            Lifecycle.State.RESUMED
        ) { state ->
            state.onSuccess { list ->
                rcListEmployee.visible()
                adapterEmployee.apply {
                    submitList(list.orEmpty())
                    setOnItemEmployeeClicked { data ->
                        navigateToDetail(data)
                    }
                }
                swipeListEmployee.isRefreshing = false
            }.onError {
                showToastMessage(it.orEmpty())
                rcListEmployee.gone()
                swipeListEmployee.isRefreshing = false
            }.onEmpty {
                rcListEmployee.gone()
                swipeListEmployee.isRefreshing = false
            }
        }
    }

    private fun initAdapter() = with(binding.rcListEmployee) {
        adapter = adapterEmployee
        isNestedScrollingEnabled = true
        val verticalLayout = verticalLinearLayoutManager()
        layoutManager = verticalLayout
        addItemDecoration(
            CustomMarginDecoration(
                topPadding = 15.dpToPixels(context).toInt(),
                bottomPadding = 20.dpToPixels(context).toInt()
            )
        )
    }

    private fun navigateToDetail(data: EmployeeItemUI) {
        navigate(
            route = RouteEnum.DETAIL_EMPLOYEE.getRouteName(this),
            extras = mapOf(Const.EMPLOYEE_DATA to data)
        )
    }
}