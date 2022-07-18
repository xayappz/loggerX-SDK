package com.xayappz.xaysdk.repository

import android.util.Log
import com.xayappz.xaysdk.LocationEvent
import com.xayappz.xaysdk.helper.ApiHelper
import com.xayappz.xaysdk.helper.LogResponse
import com.xayappz.xaysdk.interfaces.LogService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogRepository constructor(
    private val logService: LogService,
    private val responseCallback: ApiHelper.ResponseCallback
) {
    fun sendLogToServer(logEvent: LocationEvent) {
        val response = logService.sendLog(logEvent)
        response.enqueue(object : Callback<LogResponse> {
            override fun onResponse(call: Call<LogResponse>, response: Response<LogResponse>) {
                responseCallback.onApiCall(response.isSuccessful) //true or false response result.
                if (!response.isSuccessful) {
                    sendLogToServer(logEvent) // requesting back to server in case of any server exception.
                } else {
                    response.body()?.let {
                        Log.d(
                            "onSuccess->",
                            it.data // print true or false on Api success or any error.
                        )
                    }
                }
            }

            override fun onFailure(call: Call<LogResponse>, t: Throwable) {
                if (t.localizedMessage.contains("No address")) {
                    responseCallback.onApiCall(false) // false result when any error like no internet connection etc.
                } else {
                    sendLogToServer(logEvent) // requesting back to server in case of any other exception.
                }

            }
        })
    }


}

