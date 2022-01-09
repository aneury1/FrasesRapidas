package com.aneury1.frasesrapidas.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aneury1.frasesrapidas.model.Quote
import com.aneury1.frasesrapidas.model.QuoteProvider

class QuoteViewModel : ViewModel() {

   val quoteModel = MutableLiveData<Quote>()

    fun randomQuote(){
        val randomQuote = QuoteProvider.getQuote()
        quoteModel.postValue(randomQuote)
    }

}