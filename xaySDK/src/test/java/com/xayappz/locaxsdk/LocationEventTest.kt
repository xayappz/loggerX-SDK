package com.xayappz.locaxsdk

import com.xayappz.xaysdk.Library
import com.xayappz.xaysdk.LocationEvent
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class LocationEventTest {
    private lateinit var library: Library

    @Before
    fun setup() {
        library=Library()
    }

    @Test
    fun checkLogData() {
        val result = library.log(LocationEvent(1f, 1f))
        assertTrue(result.equals(true))
    }
}