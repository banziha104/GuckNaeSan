package com.example.iyeongjun.gucknaesan.di.module

import com.example.iyeongjun.gucknaesan.api.arch.GovApi
import com.example.iyeongjun.gucknaesan.api.arch.TourApi
import com.example.iyeongjun.gucknaesan.const.SERVER_URL
import com.example.iyeongjun.gucknaesan.const.TOUR_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule{

    @Singleton

    @Provides
    fun provideGovApi(rxAdapter : CallAdapter.Factory,
                      @Named("gson")gsonConverter: Converter.Factory,
                      client : OkHttpClient) = Retrofit
            .Builder()
            .baseUrl(SERVER_URL)
            .client(client)
            .addCallAdapterFactory(rxAdapter)
            .addConverterFactory(gsonConverter)
            .build()
            .create(GovApi::class.java)

    @Provides
    @Singleton
    fun provideTourApi(rxAdapter: CallAdapter.Factory,
                       @Named("xml") xmlConverter : Converter.Factory,
                       client: OkHttpClient)
            = Retrofit.Builder()
            .baseUrl(TOUR_URL)
            .client(client)
            .addCallAdapterFactory(rxAdapter)
            .addConverterFactory(xmlConverter)
            .build()
            .create(TourApi::class.java)


    @Provides
    @Singleton
    fun provideCallAdapterFactory(): CallAdapter.Factory // RxConvererter
            = RxJava2CallAdapterFactory.createAsync()

    @Provides
    @Singleton
    @Named("xml")
    fun provideXmlConverterFactory() : Converter.Factory
            = SimpleXmlConverterFactory.create()
    @Provides
    @Singleton
    @Named("gson")
    fun provideConverterFactory(): Converter.Factory // GsonFactory
            = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient
            = OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()


}