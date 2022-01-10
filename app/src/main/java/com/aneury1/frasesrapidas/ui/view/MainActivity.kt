package com.aneury1.frasesrapidas.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.aneury1.frasesrapidas.ui.ViewModel.QuoteViewModel
import com.aneury1.frasesrapidas.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val quoteViewModel : QuoteViewModel by viewModels()
    lateinit var mainBinding :ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        quoteViewModel.onCreateViewModel()

        // Update View by Change the View Model
        quoteViewModel.quoteModel.observe(this,{
            mainBinding.quote.text = it.quote
        })

        quoteViewModel.isLoading.observe(this,{
            mainBinding.progress1.isVisible = it
        })

        //Set SCreen Listener
        mainBinding.screento.setOnClickListener{
            quoteViewModel.randomQuote()
        }
    }
}