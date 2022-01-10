package com.aneury1.frasesrapidas.domain

import com.aneury1.frasesrapidas.data.QuoteRepository
import com.aneury1.frasesrapidas.data.model.Quote
import javax.inject.Inject

class GetQuoteUseCase  @Inject constructor( private val repository :QuoteRepository ){
    suspend operator fun invoke(): List<Quote>?= repository.getAllQuote()
}