package com.aneury1.frasesrapidas.domain

import com.aneury1.frasesrapidas.data.QuoteRepository
import com.aneury1.frasesrapidas.data.model.Quote
import com.aneury1.frasesrapidas.data.model.QuoteProvider

class GetRandomUseCase {
  ////  private val repository = QuoteRepository()
     operator fun invoke():  Quote?{
         return QuoteProvider.getQuote()
     }
}