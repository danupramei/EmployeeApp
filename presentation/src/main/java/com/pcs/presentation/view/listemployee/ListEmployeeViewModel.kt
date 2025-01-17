package com.pcs.presentation.view.listemployee

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pcs.domain.usecases.GetListEmployeeUseCase
import com.pcs.presentation.mapper.toListUI
import com.pcs.presentation.models.EmployeeItemUI
import com.pcs.presentation.utils.UiState
import com.pcs.presentation.utils.mapToModelUi
import com.pcs.presentation.utils.mapToUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListEmployeeViewModel @Inject constructor(
    private val getListEmployeeUseCase: GetListEmployeeUseCase
) : ViewModel() {
    private val _listEmployee =
        MutableStateFlow<UiState<List<EmployeeItemUI>>>(UiState.Uninitialized)
    val listEmployee get() = _listEmployee.asStateFlow()

    fun getListEmployee() {
        viewModelScope.launch(Dispatchers.IO) {
            _listEmployee.emit(UiState.Loading)
            val result = getListEmployeeUseCase().mapToModelUi { it.toListUI() }
            _listEmployee.mapToUiState(result, Dispatchers.Main)
        }
    }
}