package com.sample.android.testing.chap02.section0206

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

class WeatherForecast_spyTest {

    lateinit var weatherForecast: WeatherForecast
    lateinit var formatter: WeatherFormatter

    @Before
    fun setUp() {
        formatter = spy(WeatherFormatter())
        val satellite = Satellite()
        val recorder = WeatherRecorder()
        weatherForecast = WeatherForecast(satellite, recorder, formatter)
    }

    @Test
    fun recordCurrentWeather_assertFormatterCalled() {
        weatherForecast.recordCurrentWeather(37.580006, -122.345106)
        verify(formatter, times(1)).format(any())
    }
}
