package com.sample.android.testing.chap02.section0206

open class Satellite {

    open fun getWeather(latitude: Double, longitude: Double): Weather {
        return Weather.RAINY
    }
}
