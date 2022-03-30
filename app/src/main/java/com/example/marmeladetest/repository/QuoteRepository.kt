package com.example.marmeladetest.repository

import com.apollographql.apollo.api.Response

interface QuoteRepository {
    suspend fun queryQuoteList(): Response<QuoteListQuery.Data>
}