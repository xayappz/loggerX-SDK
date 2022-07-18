package com.xayappz.xaysdk.interfaces

import com.xayappz.xaysdk.LocationEvent
import com.xayappz.xaysdk.helper.LogResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface LogService {
    //on below line we are creating a method to post our data.
    @POST("/post")
    fun sendLog(@Body bodyData: LocationEvent): Call<LogResponse>
}