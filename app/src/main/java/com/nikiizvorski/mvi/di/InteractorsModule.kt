package com.nikiizvorski.mvi.di

import com.nikiizvorski.mvi.api.AppService
import com.nikiizvorski.mvi.db.PhotosDao
import com.nikiizvorski.mvi.interactors.PhotoInteractorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule {

    @Singleton
    @Provides
    fun provideInteractors(
        cacheDataSource: PhotosDao,
        networkDataSource: AppService
    ): PhotoInteractorImpl {
        return PhotoInteractorImpl(cacheDataSource, networkDataSource)
    }
}














