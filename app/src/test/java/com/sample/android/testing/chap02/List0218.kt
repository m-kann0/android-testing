package com.sample.android.testing.chap02

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.within
import org.junit.Test

class List0218 {

    @Test
    fun test() {
        assertThat(3.14159)
            .isNotZero()
            .isNotNegative()
            .isGreaterThan(3.0)
            .isLessThanOrEqualTo(4.0)
            .isBetween(3.0, 3.2)
            .isCloseTo(Math.PI, within(0.001))
    }
}
