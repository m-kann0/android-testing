package com.sample.android.testing.chap02

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class List0216 {

    @Test
    fun test() {
        assertThat("TOKYO")
            .`as`("TEXT CHECK TOKYO")
            .isEqualTo("TOKYO")
            .isEqualToIgnoringCase("tokyo")
            .isNotEqualTo("KYOTO")
            .isNotBlank()
            .startsWith("TO")
            .endsWith("YO")
            .contains("OKY")
            .matches("[A-Z]{5}")
            .isInstanceOf(String::class.java)
    }
}
