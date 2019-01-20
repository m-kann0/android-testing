package com.sample.android.testing.chap03.section0301

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.sample.android.testing.R
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class JetpackTest {

    @Test
    fun gettingContextTest() {
        val context = InstrumentationRegistry.getTargetContext()
        val appName = context.getString(R.string.app_name)
        assertThat(appName).isEqualTo("android-testing")
    }
}
