package com.sample.android.testing.chap02.section0206

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Silent::class)
class AnnotationTest {

    @Mock
    lateinit var satellite: Satellite

    @Mock
    lateinit var recorder: WeatherRecorder

    @Spy
    val formatter: WeatherFormatter = WeatherFormatter()

    lateinit var weatherForecast: WeatherForecast

    @Before
    fun setUp() {
        whenever(satellite.getWeather(any(), any())).thenReturn(Weather.SUNNY)
        weatherForecast = WeatherForecast(satellite, recorder, formatter)
    }

    @Test
    fun test() {
        weatherForecast.recordCurrentWeather(0.0, 0.0)
        verify(formatter, times(1)).format(Weather.SUNNY)
    }
}
