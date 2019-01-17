package com.sample.android.testing.chap02.section0205

class WeatherForecast(val satellite: Satellite,
                      val recorder: WeatherRecorder,
                      val formatter: WeatherFormatter) {

    fun shouldBringUmbrella(): Boolean {
        val weather: Weather = satellite.getWeather()
        return when(weather) {
            Weather.SUNNY, Weather.CLOUDY -> false
            Weather.RAINY -> true
        }
    }

    fun recordCurrentWeather() {
        val weather = satellite.getWeather()
        val formatted = formatter.format(weather)
        recorder.record(formatted)
    }
}
