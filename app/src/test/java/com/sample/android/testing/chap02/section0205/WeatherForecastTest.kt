package com.sample.android.testing.chap02.section0205

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class WeatherForecastTest {

    @Test
    fun shouldBringUmbrella_givenSunny_returnsFalse() {
        val satellite = StubSatellite(Weather.SUNNY)
        val recorder = MockWeatherRecorder()
        val weatherForecast = WeatherForecast(satellite, recorder, WeatherFormatter())

        val actual = weatherForecast.shouldBringUmbrella()
        assertThat(actual).isFalse()
    }

    @Test
    fun recordCurrentWeather_assertCalled() {
        val satellite = Satellite()
        val recorder = MockWeatherRecorder()
        val formatter = WeatherFormatter()
        val weatherForecast = WeatherForecast(satellite, recorder, formatter)

        weatherForecast.recordCurrentWeather()

        val isCalled = recorder.isCalled
        assertThat(isCalled).isTrue()

        val weather = recorder.weather
        assertThat(weather).isIn(
            formatter.format(Weather.SUNNY),
            formatter.format(Weather.CLOUDY),
            formatter.format(Weather.RAINY)
        )
    }

    @Test
    fun recordCurrentWeather_assertFormatterCalled() {
        val satellite = Satellite()
        val recorder = WeatherRecorder()
        val formatter = SpyWeatherFormatter()
        val weatherForecast = WeatherForecast(satellite, recorder, formatter)

        weatherForecast.recordCurrentWeather()

        val isCalled = formatter.isCalled
        assertThat(isCalled).isTrue()

        val weather = formatter.weather
        assertThat(weather)
            .isIn(*Weather.values())
    }

    class StubSatellite(val anyWeather: Weather) : Satellite() {
        override fun getWeather(): Weather {
            return anyWeather
        }
    }

    class MockWeatherRecorder : WeatherRecorder() {
        var weather: String? = null
        var isCalled = false

        override fun record(weather: String) {
            this.weather = weather
            isCalled = true
        }
    }

    class SpyWeatherFormatter : WeatherFormatter() {
        var weather: Weather? = null
        var isCalled = false

        override fun format(weather: Weather): String {
            this.weather = weather
            isCalled = true
            return super.format(weather)
        }
    }
}
