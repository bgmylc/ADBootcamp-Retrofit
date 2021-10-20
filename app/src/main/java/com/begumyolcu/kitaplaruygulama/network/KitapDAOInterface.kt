package com.begumyolcu.kitaplaruygulama.network

import com.begumyolcu.kitaplaruygulama.response.KitaplarResponse
import retrofit2.Call
import retrofit2.http.GET

interface KitapDAOInterface {

    @GET("all_books.php")
    fun kitaplariAl() : Call<KitaplarResponse>
}