package com.macbook.softus.viewpayment.data

import com.macbook.softus.viewpayment.data.model.ApiDataPayment
import com.macbook.softus.viewpayment.io.RetrofitClient
import com.macbook.softus.viewpayment.vo.Resource

class DataSource {

    suspend fun getPayments(): Resource<List<ApiDataPayment>> {
        return Resource.Success(RetrofitClient.webservice.getPayments())
    }
}