package com.example.something.data.local

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceManager @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    companion object {
        private const val FIRST_ENTER_WELCOME = "entered_welcome"
    }

    fun setFirstEnterWelcome(value: Boolean) {
        sharedPreferences.edit { putBoolean(FIRST_ENTER_WELCOME, value) }
    }

    fun isFirstEnterWelcome(): Boolean {
        return sharedPreferences.getBoolean(FIRST_ENTER_WELCOME, false)
    }

}