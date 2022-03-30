package com.example.marmeladetest.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apollographql.apollo.api.Response
import com.example.marmeladetest.repository.QuoteRepository
import com.example.marmeladetest.view.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val repository: QuoteRepository,
    ): ViewModel() {
    private val _quoteList by lazy { MutableLiveData<ViewState<Response<QuoteListQuery.Data>>>() }
    val charactersList: LiveData<ViewState<Response<QuoteListQuery.Data>>>
        get() = _quoteList
}