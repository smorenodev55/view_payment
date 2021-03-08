package com.macbook.softus.viewpayment.data.model

import com.google.gson.annotations.SerializedName

data class ApiDataPayment(

    @SerializedName("number")
    val update: String? = null,

    @SerializedName("type")
    val suffix: String? = null
)