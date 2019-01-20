package com.sample.android.testing.chap02.section0206

import com.nhaarman.mockitokotlin2.*
import org.junit.Test

class SpyTest2 {

    @Test
    fun test() {
        val fetcher: OtherThingFetcher = mock()
        whenever(fetcher.fetchOtherThing()).thenReturn("OTHER")

        val handler: OtherThingHandler = mock()
        val targetClass: TargetClass = spy(TargetClass(fetcher, handler))

        targetClass.doSomething()
        verify(handler).doWithOtherThing(eq("OTHER"))
    }
}

open class TargetClass(val fetcher: OtherThingFetcher,
                       val handler: OtherThingHandler) {

    open fun doSomething() {
        val text = fetcher.fetchOtherThing()
        handler.doWithOtherThing(text)
    }
}

open class OtherThingFetcher {

    open fun fetchOtherThing(): String {
        return "OtherThing"
    }
}

open class OtherThingHandler {

    open fun doWithOtherThing(text: String) {

    }
}
