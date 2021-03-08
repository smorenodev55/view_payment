package com.macbook.softus.viewpayment.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.macbook.softus.viewpayment.domain.Repo
import com.macbook.softus.viewpayment.vo.Resource
import kotlinx.coroutines.Dispatchers

class HomeViewModel(private val repo: Repo) : ViewModel() {
   val fetchPayments = liveData(Dispatchers.IO){
       emit(Resource.Loading())
       try {
           emit(repo.getPayments())
       } catch (e: Exception){
           emit(Resource.Failure(e))
       }
   }
}