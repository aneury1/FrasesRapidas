package com.aneury1.frasesrapidas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.aneury1.frasesrapidas.ViewModel.QuoteViewModel
import com.aneury1.frasesrapidas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val quoteViewModel : QuoteViewModel by viewModels()
    lateinit var mainBinding :ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        quoteViewModel.quoteModel.observe(this,{
            mainBinding.quote.text = it.quote
        })
        mainBinding.screento.setOnClickListener{
            quoteViewModel.randomQuote()
        }
    }
}