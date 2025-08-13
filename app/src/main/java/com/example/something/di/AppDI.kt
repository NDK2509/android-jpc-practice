package com.example.something.di

import android.content.Context
import android.content.SharedPreferences
import com.example.something.data.local.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext appContext: Context): SharedPreferences {
        return appContext.getSharedPreferences("something_prefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferenceManager(sharedPreferences: SharedPreferences): PreferenceManager {
        return PreferenceManager(sharedPreferences)
    }
}