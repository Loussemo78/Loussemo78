package com.example.marmeladetest.network

import android.os.Looper
import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

class MarmeladeApi {

    fun getApolloClient(): ApolloClient {
        check (Looper.myLooper() == Looper.getMainLooper()) {
            "Seul le thread principal peut obtenir l'instance apolloClient"
        }

        val okHttpClient = OkHttpClient.Builder().build()
        return ApolloClient.builder()
            .serverUrl("https://demotivation-quotes-api.herokuapp.com/")
            .okHttpClient(okHttpClient)
            .build()
    }
}