package com.macbook.softus.viewpayment.io

import com.macbook.softus.viewpayment.data.model.ApiDataPayment
import retrofit2.http.GET

interface ApiService {

    //Get Payments
    @GET("payments")
    suspend fun getPayments() : List<ApiDataPayment>
}