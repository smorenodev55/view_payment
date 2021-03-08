package com.macbook.softus.viewpayment.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.macbook.softus.viewpayment.data.model.ApiDataPayment
import com.macbook.softus.viewpayment.databinding.ItemPaymentBinding
import com.macbook.softus.viewpayment.utils.BaseViewHolder

class PaymentAdapter(
    private val context: Context,
    private val listPayments: List<ApiDataPayment>
) : RecyclerView.Adapter<BaseViewHolder<*>>(){

    inner class PaymentViewHolder(private val binding: ItemPaymentBinding):
    BaseViewHolder<ApiDataPayment>(binding.root){
        override fun bind(item: ApiDataPayment, position: Int) = with(binding)  {
            txtNumberCard.text = item.number
            txtCard.text = item.type
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ItemPaymentBinding.inflate(LayoutInflater.from(context), parent, false)
        return PaymentViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is PaymentViewHolder -> holder.bind(listPayments[position], position)
        }
    }

    override fun getItemCount() = listPayments.size
}