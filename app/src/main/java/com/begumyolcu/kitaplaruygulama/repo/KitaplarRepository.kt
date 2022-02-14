package com.begumyolcu.kitaplaruygulama.repo

import androidx.lifecycle.MutableLiveData
import com.begumyolcu.kitaplaruygulama.model.Kitap
import com.begumyolcu.kitaplaruygulama.network.ApiUtils
import com.begumyolcu.kitaplaruygulama.response.KitaplarResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KitaplarRepository {
    val kitaplarList = MutableLiveData<List<Kitap>>()

    init {
        kitaplariGetir()
    }

    fun kitaplariGetir() {
        ApiUtils.kitapDAOInterfaceGetir().kitaplariAl().enqueue(
            object : Callback<KitaplarResponse> {
                override fun onResponse(
                    call: Call<KitaplarResponse>,
                    response: Response<KitaplarResponse>
                ) {
                    val tempList = response.body()?.books
                    kitaplarList.value = tempList
                    //println(kitaplarList)
                }

                override fun onFailure(call: Call<KitaplarResponse>, t: Throwable) {}

            }
        )
    }

    fun getirKitaplar() : MutableLiveData<List<Kitap>>{
        return kitaplarList
    }

}