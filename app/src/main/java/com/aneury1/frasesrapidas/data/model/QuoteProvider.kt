package com.aneury1.frasesrapidas.data.model

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class QuoteProvider @Inject constructor(){

    private val isLocal = false;

    var quotesOnline :List<Quote> = emptyList()

    private val localQuotes = listOf<Quote>(
        Quote("1","aneury"),
        Quote("2","aneury"),
        Quote("4","aneury"),
        Quote("5","aneury"),
        Quote("4","aneury"),
        Quote("45","aneury"),
        Quote("5451","aneury"),
        Quote("154545","aneury"),
        Quote("13434","aneury"),
        Quote("154545","aneury"),
        Quote("1r4545","aneury"),
        Quote("54454551","aneury"),
        Quote("4554451","aneury"),
        Quote("54554451","aneury"),
        Quote("4545451","aneury"),
        Quote("1544554","aneury"),
        Quote("154454545","aneury"),
        Quote("544545451","aneury"),
        Quote("54545451","aneury"),
        Quote("5445451","aneury"),
        Quote("454545451","aneury"),
    )

    fun getQuoteLocal(): Quote{
        val position = (0..20).random()
        return localQuotes[position]
    }
    fun getQuote():Quote{
        if(isLocal || quotesOnline.isEmpty())return getQuoteLocal()
        val position = (0..quotesOnline.size-1).random()
        return quotesOnline[position]
    }
}