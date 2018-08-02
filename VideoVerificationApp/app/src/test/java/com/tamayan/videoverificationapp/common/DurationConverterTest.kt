package com.tamayan.videoverificationapp.common

import org.junit.Assert.assertEquals
import org.junit.Test

class DurationConverterTest {

    @Test
    fun convertHourTestSuccess() {
        assertEquals(DurationConverter.convert("PT10H1M1S"), "10:01:01")
        assertEquals(DurationConverter.convert("PT1H1M1S"), "1:01:01")
    }

    @Test
    fun convertMinuteTestSuccess() {
        assertEquals(DurationConverter.convert("PT10M1S"), "10:01")
        assertEquals(DurationConverter.convert("PT1M1S"), "1:01")
    }

    @Test
    fun convertSecondTestSuccess() {
        assertEquals(DurationConverter.convert("PT10S"), "0:10")
        assertEquals(DurationConverter.convert("PT1S"), "0:01")
    }
}