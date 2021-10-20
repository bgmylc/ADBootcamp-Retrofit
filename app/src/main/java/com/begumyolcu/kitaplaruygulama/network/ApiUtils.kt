package com.begumyolcu.kitaplaruygulama.network

class ApiUtils {

    companion object {

        private const val BASE_URL = "http://books.canerture.com/"

        fun kitapDAOInterfaceGetir() : KitapDAOInterface {
            return RetrofitClient.getClient(BASE_URL).create(KitapDAOInterface::class.java)
        }
    }
}