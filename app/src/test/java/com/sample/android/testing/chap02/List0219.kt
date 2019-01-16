package com.sample.android.testing.chap02

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class List0219 {

    @Test
    fun test() {
        val target = listOf("Giants", "Dodgers", "Athletics")

        assertThat(target)
            .hasSize(3)
            .contains("Dodgers")
            .containsOnly("Athletics", "Dodgers", "Giants")
            .containsExactly("Giants", "Dodgers", "Athletics")
            .doesNotContain("Padres")
    }
}
