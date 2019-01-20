package com.sample.android.testing.chap02.section0206

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DeclarativeMockTest {

    @Test
    fun test() {
        val satellite = mock<Satellite>(name = "MockSatellite") {
            on { getWeather(any(), any()) } doReturn Weather.CLOUDY
            on { getWeather(eq(37.580006), eq(-122.345106)) } doReturn Weather.SUNNY
        }

        val actual = satellite.getWeather(0.0, 0.0)
        assertThat(actual).isEqualTo(Weather.CLOUDY)
    }
}
