package com.kineduchallenge.module

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.ContextWrapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideActivityViewModel(@ApplicationContext context: Context): Activity? = context.activity()
}

private tailrec fun Context?.activity(): Activity? = this as? Activity
    ?: (this as? ContextWrapper)?.baseContext?.activity()