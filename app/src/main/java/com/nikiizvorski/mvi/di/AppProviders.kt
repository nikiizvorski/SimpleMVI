package com.nikiizvorski.mvi.di

import android.app.Application
import android.content.Context
import androidx.annotation.NonNull
import androidx.room.Room
import com.nikiizvorski.mvi.api.AppService
import com.nikiizvorski.mvi.db.PhotosDB
import com.nikiizvorski.mvi.db.PhotosDao
import com.nikiizvorski.mvi.ext.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppProviders {

    /**
     *
     * @param application Application
     * @return Context
     */
    @Provides
    @Singleton
    fun provideContext(application: Application) : Context {
        return application.applicationContext
    }

    /**
     *
     * @return OkHttpClient
     */
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    /**
     *
     * @param okHttpClient OkHttpClient
     * @return Retrofit
     */
    @Provides
    @Singleton
    fun provideRetrofit(@NonNull okHttpClient: OkHttpClient): Retrofit {
        /**
         * Remove the adapter and try newNetworkList next time to see where is your issue ;(
         */
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    /**
     *
     * @param retrofit Retrofit
     * @return AppService
     */
    @Provides
    @Singleton
    fun providePostService(@NonNull retrofit: Retrofit): AppService {
        return retrofit.create(AppService::class.java)
    }

    /**
     *
     * @param application Application
     * @return AppDB
     */
    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): PhotosDB {
        return Room.databaseBuilder(application.applicationContext, PhotosDB::class.java, "postove.db").allowMainThreadQueries().build()
    }

    /**
     *
     * @param database AppDB
     * @return AppDAO
     */
    @Provides
    @Singleton
    fun provideHistoryDao(@NonNull database: PhotosDB): PhotosDao {
        return database.photosDB()
    }
}