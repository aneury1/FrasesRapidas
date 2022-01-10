package com.aneury1.frasesrapidas.data

import com.aneury1.frasesrapidas.data.model.Quote
import com.aneury1.frasesrapidas.data.model.QuoteProvider
import com.aneury1.frasesrapidas.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api : QuoteService, private val quoteProvider: QuoteProvider ){
    suspend fun getAllQuote(): List<Quote>{
        val response = api.getQuotes()
        quoteProvider.quotesOnline = response
        return response
    }
}