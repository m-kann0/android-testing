package com.sample.android.testing.chap02.section0206

import com.nhaarman.mockitokotlin2.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class WeatherForecast_recordCurrentWeatherTest {

    lateinit var weatherForecast: WeatherForecast
    lateinit var recorder: WeatherRecorder

    @Before
    fun setUp() {
        recorder = mock(name = "MockRecorder")
        val satellite = Satellite()
        val formatter = WeatherFormatter()
        weatherForecast = WeatherForecast(satellite, recorder, formatter)
    }

    @Test
    fun recordCurrentWeather_assertRecorderCalled() {
        weatherForecast.recordCurrentWeather(37.580006, -122.345106)

        argumentCaptor<Record>().apply {
            verify(recorder, times(1)).record(capture())
            assertThat(firstValue.description).isEqualTo("Weather is RAINY")
        }
    }
}
