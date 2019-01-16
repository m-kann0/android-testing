package com.sample.android.testing.chap02

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.Test

class List0222 {

    @Test
    fun test() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { functionMayThrow() }
            .withMessage("Aborted!")
            .withNoCause()
    }

    fun functionMayThrow() {
        throw RuntimeException("Aborted!")
    }
}
