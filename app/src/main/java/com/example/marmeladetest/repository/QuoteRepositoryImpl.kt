package com.example.marmeladetest.repository

import QuoteListQuery
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.example.marmeladetest.network.MarmeladeApi
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val service: MarmeladeApi
) : QuoteRepository {
    override suspend fun queryQuoteList(): Response<QuoteListQuery.Data> {
        return service.getApolloClient().query(QuoteListQuery()).await()
    }
}