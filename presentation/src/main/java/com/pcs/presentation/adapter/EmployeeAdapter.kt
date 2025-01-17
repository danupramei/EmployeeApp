package com.pcs.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.pcs.presentation.databinding.ItemEmployeeBinding
import com.pcs.presentation.models.EmployeeItemUI
import com.pcs.shared.base.BaseAdapter
import com.pcs.shared.base.BaseDiffUtil
import com.pcs.shared.extent.clickWithDebounce
import com.pcs.shared.extent.loadNetworkImage
import com.pcs.shared.utils.DateConverter
import javax.inject.Inject

class EmployeeAdapter @Inject constructor() : BaseAdapter<EmployeeItemUI, ItemEmployeeBinding>(
    diffCallback = BaseDiffUtil(
        areItemsTheSame = { oldItem, newItem -> oldItem.id == newItem.id },
        areContentsTheSame = { oldItem, newItem -> oldItem == newItem }
    )
) {
    private var onItemClicked: (EmployeeItemUI) -> Unit = {}

    fun setOnItemEmployeeClicked(onItemClicked: (EmployeeItemUI) -> Unit) {
        this.onItemClicked = onItemClicked
    }

    override fun bind(binding: ItemEmployeeBinding, item: EmployeeItemUI, position: Int) =
        with(binding) {
            tvNameEmployee.text = item.fullName
            tvDob.text = DateConverter().formatDate(item.dob)
            ivImgEmployee.loadNetworkImage(item.avatar)
            root.clickWithDebounce {
                onItemClicked.invoke(item)
            }
        }

    override fun inflateBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean
    ): ItemEmployeeBinding {
        return ItemEmployeeBinding.inflate(inflater, parent, attachToParent)
    }
}