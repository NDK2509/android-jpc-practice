package com.example.something.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.something.data.local.PreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val preferenceManager: PreferenceManager
) : ViewModel() {
    fun isFirstEnterWelcome(): Boolean = preferenceManager.isFirstEnterWelcome()
    fun onFocus() {
        preferenceManager.setFirstEnterWelcome(true)
    }
}