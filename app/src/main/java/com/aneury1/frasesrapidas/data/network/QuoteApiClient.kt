package com.aneury1.frasesrapidas.data.network

import com.aneury1.frasesrapidas.data.model.Quote
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/quotes.json")
    suspend fun getAllQuote(): Response<List<Quote>>
}