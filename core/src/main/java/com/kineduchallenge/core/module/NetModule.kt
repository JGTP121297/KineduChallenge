package com.kineduchallenge.core.module

import com.google.gson.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Provides
    fun provideGson(): Gson =
        GsonBuilder().setExclusionStrategies(object : ExclusionStrategy {
            override fun shouldSkipField(f: FieldAttributes?): Boolean =
                f?.name?.startsWith("io_realm_kotlin_") ?: false

            override fun shouldSkipClass(clazz: Class<*>?): Boolean = false

        }).create()

    @Provides
    fun provideInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val client = OkHttpClient().newBuilder()
        client.addInterceptor(interceptor)
        client.readTimeout(TIME_OUT, TimeUnit.SECONDS)
        client.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        return client.build()
    }

    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com/v1/public/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .callFactory(okHttpClient)
            .build()
    }

    companion object {
        private const val TIME_OUT = 30L
    }

}