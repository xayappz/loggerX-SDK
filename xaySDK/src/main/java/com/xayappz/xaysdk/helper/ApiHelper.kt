package com.xayappz.xaysdk.helper

import com.xayappz.locaxsdk.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiHelper {
    private const val BASE_URL = BuildConfig.API_URL //base httpbin Api URL.
    fun getInstance(): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build() //retrofit instance.
    }

    interface ResponseCallback {
        fun onApiCall(data: Boolean)
    }  //end api result (true or false).

    interface ResponseCallbackMsg {
        fun onApiCallMsg():String //end api response msg.
    }
}