package com.example.marmeladetest.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.marmeladetest.databinding.FragmentQuoteListBinding
import com.example.marmeladetest.view.ViewState
import com.example.marmeladetest.view.adapter.QuoteAdapter
import com.example.marmeladetest.view.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class QuoteListFragment : Fragment() {

    private lateinit var binding : FragmentQuoteListBinding
    private val quoteAdapter by lazy { QuoteAdapter() }
    private val viewModel by viewModels <QuoteViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        enabledInstanceState: Bundle?
    ): View {
        binding = FragmentQuoteListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.quoteList.adapter = quoteAdapter
        viewModel.queryQuoteList()
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.quoteList.observe(viewLifecycleOwner) { response ->
            when (response) {
                is ViewState.Loading -> {
                    binding.quoteList.visibility = View.GONE
                    //binding.quoteFetchProgress.visibility = View.VISIBLE
                }
                is ViewState.Success -> {
                    if (response.value?.data?.quotes?.size == 0) {
                        quoteAdapter.submitList(emptyList())
                       // binding.quoteFetchProgress.visibility = View.GONE
                        binding.quoteList.visibility = View.GONE
                        binding.quoteEmptyText.visibility = View.VISIBLE
                    } else {
                        binding.quoteList.visibility = View.VISIBLE
                       // binding.quoteFetchProgress.visibility = View.GONE
                    }
                    val results = response.value?.data?.quotes
                    quoteAdapter.submitList(results)
                    //binding.quoteFetchProgress.visibility = View.GONE
                }
                is ViewState.Error -> {
                    quoteAdapter.submitList(emptyList())
                    //binding.quoteFetchProgress.visibility = View.GONE
                    binding.quoteList.visibility = View.GONE
                    binding.quoteEmptyText.visibility = View.VISIBLE
                }
            }
        }
    }
}