package com.nikiizvorski.mvi.interactors

import android.accounts.NetworkErrorException
import android.util.Log
import com.nikiizvorski.mvi.api.AppService
import com.nikiizvorski.mvi.db.PhotosDao
import com.nikiizvorski.mvi.entity.Photo
import com.nikiizvorski.mvi.ext.APP_KEY
import com.nikiizvorski.mvi.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class PhotoInteractorImpl @Inject constructor(private val photosDao: PhotosDao, private val deviceService: AppService): PhotoInteractor{

    private val TAG: String = "AppDebug"

    /**
     * Show loading
     * Get blogs from network
     * Insert blogs into cache
     * Show List<Blog>
     */
    suspend fun execute(): Flow<DataState<List<Photo>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        val response = retryIO { deviceService.getNewPhotos(APP_KEY) }

        if (response.isSuccessful) {
            photosDao.insertAll(response.body()!!.photos)
            emit(DataState.Success(photosDao.all))
        } else {
            DataState.Error(NetworkErrorException(response.errorBody().toString()))
        }
    }

    /**
     *
     * @param times Int
     * @param initialDelay Long
     * @param maxDelay Long
     * @param factor Double
     * @param block SuspendFunction0<T>
     * @return T
     */
    suspend fun <T> retryIO(
        times: Int = Int.MAX_VALUE,
        initialDelay: Long = 100, // 0.1 second
        maxDelay: Long = 1000,    // 1 second
        factor: Double = 2.0,
        block: suspend () -> T): T
    {
        var currentDelay = initialDelay
        repeat(times - 1) {
            try {
                return block()
            } catch (e: IOException) {
                Log.e(TAG, "Exception:" + e.cause)
            }
            delay(currentDelay)
            currentDelay = (currentDelay * factor).toLong().coerceAtMost(maxDelay)
        }
        return block() // last attempt
    }
}
















