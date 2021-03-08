package com.macbook.softus.viewpayment.domain

import com.macbook.softus.viewpayment.data.model.*
import com.macbook.softus.viewpayment.vo.Resource

interface Repo {
    suspend fun getPayments(): Resource<List<ApiDataPayment>>
}