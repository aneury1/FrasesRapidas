package com.aneury1.frasesrapidas.ui.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aneury1.frasesrapidas.data.QuoteRepository
import com.aneury1.frasesrapidas.data.model.Quote
import com.aneury1.frasesrapidas.data.model.QuoteProvider
import com.aneury1.frasesrapidas.domain.GetQuoteUseCase
import com.aneury1.frasesrapidas.domain.GetRandomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuoteViewModel  @Inject constructor(
    private val getQuoteUseCase : GetQuoteUseCase,
    private val  getRandomUseCase: GetRandomUseCase,
    private val quoteProvider: QuoteProvider
) : ViewModel() {

   val quoteModel = MutableLiveData<Quote>()
   val isLoading = MutableLiveData<Boolean>()


    fun onCreateViewModel(){
        viewModelScope.launch {
             val result = getQuoteUseCase()
              isLoading.postValue(true)
             if(!result.isNullOrEmpty()){
                 quoteModel.postValue(result[0])
             }
             else quoteModel.postValue(quoteProvider.getQuoteLocal())
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