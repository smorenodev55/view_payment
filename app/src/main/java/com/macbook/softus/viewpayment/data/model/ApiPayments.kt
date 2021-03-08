package com.macbook.softus.viewpayment.data.model

import com.google.gson.annotations.SerializedName

data class ApiDataPayment(

    @SerializedName("number")
    val number: String? = null,

    @SerializedName("type")
    val type: String? = null
)