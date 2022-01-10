package com.aneury1.frasesrapidas.data.network

import com.aneury1.frasesrapidas.core.RetrofitHelper
import com.aneury1.frasesrapidas.data.model.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class QuoteService @Inject constructor(private val api: QuoteApiClient){

    suspend fun getQuotes(): List<Quote>{
        return withContext(Dispatchers.IO) {
            val response: Response<List<Quote>> = api.getAllQuote()
            response.body() ?: emptyList()
        }
    }
}