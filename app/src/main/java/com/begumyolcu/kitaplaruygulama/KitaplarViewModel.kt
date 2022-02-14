package com.begumyolcu.kitaplaruygulama

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.begumyolcu.kitaplaruygulama.model.Kitap
import com.begumyolcu.kitaplaruygulama.network.ApiUtils
import com.begumyolcu.kitaplaruygulama.repo.KitaplarRepository
import com.begumyolcu.kitaplaruygulama.response.KitaplarResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KitaplarViewModel : ViewModel() {
    private val kitapRepo = KitaplarRepository()
    var kitapList = MutableLiveData<List<Kitap>>()

    init {
        getKitaplar()
        kitapList = kitapRepo.getirKitaplar()
    }

    private fun getKitaplar() {
        kitapRepo.kitaplariGetir()
    }

}