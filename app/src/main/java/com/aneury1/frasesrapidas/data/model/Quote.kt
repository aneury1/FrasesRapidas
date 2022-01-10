package com.aneury1.frasesrapidas.data.model

import com.google.gson.annotations.SerializedName

data class Quote(@SerializedName("quote")val quote: String,@SerializedName("author") val author: String?="unknown")
