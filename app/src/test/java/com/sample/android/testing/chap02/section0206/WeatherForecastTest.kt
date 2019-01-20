package com.sample.android.testing.chap02.section0206

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.Before
import org.junit.Test

class WeatherForecastTest {

    lateinit var satellite: Satellite
    lateinit var weatherForecast: WeatherForecast

    @Before
    fun setUp() {
        satellite = mock(name = "MockSatellite")
        whenever(satellite.getWeather(any(), any()))
            .thenReturn(Weather.CLOUDY)
        whenever(satellite.getWeather(eq(37.580006), eq(-122.345106)))
            .thenReturn(Weather.SUNNY)
        whenever(satellite.getWeather(eq(37.792872), eq(-122.396915)))
            .thenReturn(Weather.RAINY)

        val recorder = WeatherRecorder()
        val formatter = WeatherFormatter()
        weatherForecast = WeatherForecast(satellite, recorder, formatter)
    }

    @Test
    fun shouldBringUmbrella_givenSunny_returnsFalse() {
        val actual = weatherForecast.shouldBringUmbrella(37.580006, -122.345106)
        assertThat(actual).isFalse()
    }

    @Test
    fun shouldBringUmbrella_givenCloudy_returnsFalse() {
        val actual = weatherForecast.shouldBringUmbrella(0.0, 0.0)
        assertThat(actual).isFalse()
    }

    @Test
    fun shouldBringUmbrella_givenRainy_returnsTrue() {
        val actual = weatherForecast.shouldBringUmbrella(37.792872, -122.396915)
        assertThat(actual).isTrue()
    }

    @Test
    fun test_thenAnswer() {
        whenever(satellite.getWeather(any(), any())).thenAnswer { invocation ->
            val latitude = invocation.arguments[0] as Double
            val longitude = invocation.arguments[1] as Double

            if (latitude in 20.424086..45.550999
                    && longitude in 122.933872..153.980789) {
                return@thenAnswer Weather.SUNNY
            } else {
                return@thenAnswer Weather.RAINY
            }
        }

        val actual1 = weatherForecast.shouldBringUmbrella(20.424086, 122.933872)
        assertThat(actual1).isFalse()

        val actual2 = weatherForecast.shouldBringUmbrella(20.424085, 122.933871)
        assertThat(actual2).isTrue()
    }

    @Test
    fun test_thenThrow() {
        whenever(satellite.getWeather(any(), any()))
            .thenThrow(RuntimeException("ERROR"))

        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy {
                weatherForecast.shouldBringUmbrella(37.580006, -122.345106)
            }
            .withMessage("ERROR")
            .withNoCause()
    }
}
