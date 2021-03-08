package com.macbook.softus.viewpayment.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.macbook.softus.viewpayment.R
import com.macbook.softus.viewpayment.data.DataSource
import com.macbook.softus.viewpayment.data.model.ApiDataPayment
import com.macbook.softus.viewpayment.databinding.FragmentHomeBinding
import com.macbook.softus.viewpayment.domain.RepoImpl
import com.macbook.softus.viewpayment.utils.VMFactory
import com.macbook.softus.viewpayment.vo.Resource

class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel> { VMFactory(RepoImpl(DataSource())) }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var data: List<ApiDataPayment>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvPayments.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvPayments.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        setUpObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpObservers() {
        viewModel.fetchPayments.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    data = result.data as List<ApiDataPayment>
                    data.let {
                        System.out.println("List payment: {$it}")
                        binding.rvPayments.adapter = PaymentAdapter(requireContext(), it)
                    }
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(
                        context,
                        getString(R.string.error_loading_paymets), Toast.LENGTH_SHORT
                    ).show()
                    val e = result.exception
                    Log.e("Error Api", e.toString())
                }
            }
        })
    }
}