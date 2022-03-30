package com.example.marmeladetest.repository

import com.apollographql.apollo.api.Response

class QuoteRepositoryImpl : QuoteRepository {
    override suspend fun queryQuoteList(): Response<QuoteListQuery.Data> {

    }
}