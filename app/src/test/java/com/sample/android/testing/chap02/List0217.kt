package com.sample.android.testing.chap02

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
import org.junit.Test

class List0217 {

    @Test
    fun test() {
        assertThat("TOKYO")
            .`as`("TEXT CHECK TOKYO")
            .isEqualTo("HOKKAIDO")
            .isEqualToIgnoringCase("tokyo")
            .isNotEqualTo("KYOTO")
            .isNotBlank()
            .startsWith("TO")
            .endsWith("YO")
            .contains("OKY")
            .matches("[A-Z]{5}")
            .isInstanceOf(String::class.java)
    }

    @Test
    fun testBySoftAssertion() {
        SoftAssertions().apply {
            assertThat("TOKYO")
                .`as`("TEXT CHECK TOKYO")
                .isEqualTo("HOKKAIDO")
                .isEqualToIgnoringCase("tokyo")
                .isNotEqualTo("KYOTO")
                .isNotBlank()
                .startsWith("TO")
                .endsWith("YO")
                .contains("OKY")
                .matches("[A-Z]{5}")
                .isInstanceOf(String::class.java)
        }.assertAll()
    }
}
