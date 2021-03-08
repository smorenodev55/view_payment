package com.macbook.softus.viewpayment.domain

import com.macbook.softus.viewpayment.data.DataSource
import com.macbook.softus.viewpayment.data.model.*
import com.macbook.softus.viewpayment.vo.Resource

class RepoImpl(private val dataSource: DataSource): Repo {

    override suspend fun getPayments(): Resource<List<ApiDataPayment>> {
        return dataSource.getPayments()
    }

}
