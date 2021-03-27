package com.nikiizvorski.mvi.api

import com.nikiizvorski.mvi.entity.Photos
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface AppService {
    /**
     * Get list of the people from the API
     */
    @GET("/v1/search?query=nature")
    fun getPhotos(@Header("Authorization") app_key: String?): Observable<Photos>

    @GET("/v1/search?query=nature")
    fun getFlowPhotos(@Header("Authorization") app_key: String?): Flow<Photos>

    @GET("/v1/search?query=nature")
    suspend fun getNewPhotos(@Header("Authorization") app_key: String?): Response<Photos>
}