package com.theapphideaway.jsonparsingtest.networking

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebService {

    private val BASE_URL = "https://jsonplaceholder.typicode.com"
    private var mRetrofit: Retrofit

    init {

        val okHttpClient = OkHttpClient.Builder()
            .build()

        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun getToDoApi(): WebInterface {
        return mRetrofit.create<WebInterface>(WebInterface::class.java)
    }
}