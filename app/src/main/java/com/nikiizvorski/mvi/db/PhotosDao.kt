package com.nikiizvorski.mvi.db

import androidx.room.*
import com.nikiizvorski.mvi.entity.Photo
import com.nikiizvorski.mvi.entity.Photos

@Dao
interface PhotosDao {

    /**
     *
     * @param photos Array<out Photo>
     */
    @Insert
    fun insertOne(vararg photos: Photo)

    /**
     *
     * @param photos List<Photo>
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun insertAll(photo: List<Photo>)

    /**
     * get all photos by order
     */
    @get:Query("SELECT * FROM photo ORDER BY id DESC")
    val all: List<Photo>

    /**
     *
     * @param theId Int
     * @return Array<Photo>
     */
    @Query("SELECT * FROM photo WHERE id > :theId")
    fun loadUsersWithId(theId: Int): Array<Photo>

    /**
     *
     * @param id Int
     */
    @Query("DELETE FROM photo WHERE id = :id")
    fun deleteSingleWithId(id: Int)

    /**
     *
     * @param photos Array<out Photo>
     */
    @Update
    fun updateDevices(vararg photo: Photo)

    /**
     * delete all devices
     */
    @Query("DELETE FROM photo")
    fun deleteAllFromDevices()
}