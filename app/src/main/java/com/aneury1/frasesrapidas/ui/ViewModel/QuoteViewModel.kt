package com.aneury1.frasesrapidas.ui.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aneury1.frasesrapidas.data.QuoteRepository
import com.aneury1.frasesrapidas.data.model.Quote
import com.aneury1.frasesrapidas.data.model.QuoteProvider
import com.aneury1.frasesrapidas.domain.GetQuoteUseCase
import com.aneury1.frasesrapidas.domain.GetRandomUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

   val quoteModel = MutableLiveData<Quote>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuoteUseCase = GetQuoteUseCase()
    var getRandomUseCase= GetRandomUseCase()

    fun onCreateViewModel(){
        viewModelScope.launch {
             val result = getQuoteUseCase()
              isLoading.postValue(true)
             if(!result.isNullOrEmpty()){
                 quoteModel.postValue(result[0])

             }
             else quoteModel.postValue(QuoteProvider.getQuoteLocal())
            isLoading.postValue(false)
        }
    }


    fun randomQuote(){
       isLoading.postValue(true)
       val quote = getRandomUseCase()
        if(quote!=null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }

}