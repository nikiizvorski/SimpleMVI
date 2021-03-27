package com.nikiizvorski.mvi.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nikiizvorski.mvi.entity.Photo

@Database(entities = [Photo::class ], version = 1)
abstract class PhotosDB: RoomDatabase() {

    abstract fun photosDB(): PhotosDao

    companion object{
        const val DATABASE_NAME: String = "photos_bg"
    }


}