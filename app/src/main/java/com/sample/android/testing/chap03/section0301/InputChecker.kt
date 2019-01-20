package com.sample.android.testing.chap03.section0301

import android.text.TextUtils

class InputChecker {

    fun isValid(text: String): Boolean {
        if (TextUtils.isEmpty(text)) throw IllegalArgumentException("Cannot be blank")
        return text.length >= 3 && text.matches(Regex("[a-zA-Z0-9]+"))
    }
}
