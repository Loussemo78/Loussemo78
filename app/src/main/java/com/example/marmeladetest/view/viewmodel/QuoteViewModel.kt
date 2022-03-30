package com.example.marmeladetest.view.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.marmeladetest.repository.QuoteRepository
import com.example.marmeladetest.view.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class QuoteViewModel @Inject constructor(

    private val repository: QuoteRepository,
    ): ViewModel() {
    private val _quoteList by lazy { MutableLiveData<ViewState<Response<QuoteListQuery.Data>>>() }
    val quoteList: LiveData<ViewState<Response<QuoteListQuery.Data>>>
        get() = _quoteList

    fun queryQuoteList() = viewModelScope.launch {
        _quoteList.postValue(ViewState.Loading())
        try {
            val response = repository.queryQuoteList()
            _quoteList.postValue(ViewState.Success(response))
        } catch (e: ApolloException) {
            Log.d("ApolloException", "Failure", e)
            _quoteList.postValue(ViewState.Error("Error fetching quote"))
        }
    }
}