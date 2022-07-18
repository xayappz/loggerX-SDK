package com.xayappz.xaysdk

import android.util.Log
import com.xayappz.xaysdk.helper.ApiHelper
import com.xayappz.xaysdk.interfaces.LogService
import com.xayappz.xaysdk.repository.LogRepository

public data class LocationEvent(
    val lat: Float,
    val lon: Float,
    var time: Long = System.currentTimeMillis(),
    var ext: String = "Android-Platform" //passing platform as a example param.
)

public class Library : ApiHelper.ResponseCallback {
    private lateinit var logService: LogService
    private lateinit var logRepository: LogRepository
    fun setup(): Boolean { //for further use.
        return true
    }


    fun log(event: LocationEvent): Boolean {  //returning boolean for unit testing purpose.
        if (event.lon == 0f || event.lat == 0f) { //no need to hit server in case no coordinates.
            return false
        }

        logService = ApiHelper.getInstance().create(LogService::class.java) //instantiating the logService class.
        logRepository = LogRepository(logService, this) //calling logRepository to call Api.
        logRepository.sendLogToServer(event)//calling Api to posting location data.
        return true
    }

    override fun onApiCall(result: Boolean) {
        Log.d(
            "Response---onApiCall->", result.toString() // print true or false on Api success or any error.
        )
    }

}

