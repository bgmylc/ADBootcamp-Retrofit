package com.begumyolcu.kitaplaruygulama.response

import com.begumyolcu.kitaplaruygulama.model.Kitap
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class KitaplarResponse(
    @SerializedName("books")
    @Expose var books: List<Kitap>,
    @SerializedName("success")
    @Expose var success : Int)
