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
    private val viewModel by lazy { KitaplarViewModel() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(layoutInflater)

        viewModel.kitaplarList.observe(viewLifecycleOwner) { kitaplar ->
            val kitaplarAdapter = KitaplarAdapter(kitaplar as ArrayList<Kitap>)
            binding.kitapRV.adapter = kitaplarAdapter
        }
        binding.kitapRV.layoutManager = GridLayoutManager(context, 2)
        binding.kitapRV.setHasFixedSize(true)

        return binding.root
    }


}