package com.begumyolcu.kitaplaruygulama

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.begumyolcu.kitaplaruygulama.databinding.FragmentAnasayfaBinding
import com.begumyolcu.kitaplaruygulama.model.Kitap
import com.begumyolcu.kitaplaruygulama.network.ApiUtils
import com.begumyolcu.kitaplaruygulama.response.KitaplarResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    var kitaplarList: ArrayList<Kitap> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(layoutInflater)

        kitaplariGetir()
        return binding.root
    }

    private fun kitaplariGetir() {
        ApiUtils.kitapDAOInterfaceGetir().kitaplariAl().enqueue(
            object : Callback<KitaplarResponse>{
                override fun onResponse(
                    call: Call<KitaplarResponse>,
                    response: Response<KitaplarResponse>
                ) {
                    val tempList = response.body()?.books

                    tempList?.let {
                        kitaplarList = it as ArrayList<Kitap>
                    }
                    println(kitaplarList)
                    val kitaplarAdapter = KitaplarAdapter(kitaplarList)
                    binding.kitapRV.adapter = kitaplarAdapter
                    binding.kitapRV.layoutManager = GridLayoutManager(context, 2)
                    binding.kitapRV.setHasFixedSize(true)
                }

                override fun onFailure(call: Call<KitaplarResponse>, t: Throwable) {}

            }
        )
    }
}