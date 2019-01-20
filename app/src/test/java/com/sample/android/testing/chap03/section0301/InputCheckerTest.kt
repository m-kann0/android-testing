package com.sample.android.testing.chap03.section0301

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

// @Config(minSdk = 16, maxSdk = 27)
@RunWith(RobolectricTestRunner::class)
class InputCheckerTest {

    @Test
    fun isValid_givenBlank_throwsIllegalArgumentException() {
        val target = InputChecker()
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { target.isValid("") }
            .withMessage("Cannot be blank")
    }
}
