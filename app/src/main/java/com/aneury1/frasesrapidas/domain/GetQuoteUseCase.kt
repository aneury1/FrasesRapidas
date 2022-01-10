package com.aneury1.frasesrapidas.domain

import com.aneury1.frasesrapidas.data.QuoteRepository
import com.aneury1.frasesrapidas.data.model.Quote

class GetQuoteUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<Quote>?= repository.getAllQuote()


}