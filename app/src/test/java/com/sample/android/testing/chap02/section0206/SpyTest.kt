package com.sample.android.testing.chap02.section0206

import com.nhaarman.mockitokotlin2.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.Test

class SpyTest {

    @Test
    fun test() {
        val list: ArrayList<String> = spy(arrayListOf())
        //whenever(list[any()]).thenReturn("HELLO")
        doReturn("HELLO").whenever(list)[any()]
        assertThat(list[0]).isEqualTo("HELLO")

        doThrow(RuntimeException()).whenever(list).indexOf(any())
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { list.indexOf("HOGE") }

        doNothing().whenever(list).clear()

        doAnswer { invocation ->
            val index = invocation.arguments[0] as Int
            return@doAnswer if (index == 0) "HELLO" else "WORLD"
        }.whenever(list)[any()]
        assertThat(list[0]).isEqualTo("HELLO")
        assertThat(list[1]).isEqualTo("WORLD")
    }
}
