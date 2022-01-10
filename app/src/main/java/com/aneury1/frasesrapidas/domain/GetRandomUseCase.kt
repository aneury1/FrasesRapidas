package com.aneury1.frasesrapidas.domain

import com.aneury1.frasesrapidas.data.QuoteRepository
import com.aneury1.frasesrapidas.data.model.Quote
import com.aneury1.frasesrapidas.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomUseCase @Inject constructor( private val repository :QuoteRepository,  private val quoteProvider: QuoteProvider ) {

     operator fun invoke():  Quote?{
         return quoteProvider.getQuote()
     }
}