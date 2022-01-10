package com.aneury1.frasesrapidas.data

import com.aneury1.frasesrapidas.data.model.Quote
import com.aneury1.frasesrapidas.data.model.QuoteProvider
import com.aneury1.frasesrapidas.data.network.QuoteService

class QuoteRepository {


    private val api = QuoteService()

    suspend fun getAllQuote(): List<Quote>{
        val response = api.getQuotes()
        QuoteProvider.quotesOnline = response
        return response
    }


}