package com.nikiizvorski.mvi.entity

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Photos(
    var next_page: String = "",
    var userId: Int = 0,
    @PrimaryKey
    var page: Int = 0,
    var per_page: Int = 0,
    @Ignore
    var photos: List<Photo> = emptyList(),
    var total_results: Int = 0
) : Parcelable

@Parcelize
@Entity
data class Photo(
    @PrimaryKey
    var id: Int,
    var avg_color: String,
    var height: Int,
    var liked: Boolean,
    var photographer: String,
    var photographer_id: Int,
    var photographer_url: String,
    @Embedded var src: Src?,
    var url: String,
    var width: Int
) : Parcelable {
    constructor() : this(0, "", 0, true,"",0,
        "", null, "", 0)
}

@Parcelize
data class Src(
    var landscape: String,
    var large: String,
    var large2x: String,
    var medium: String,
    @ColumnInfo(name = "pic_info") var original: String,
    var portrait: String,
    var small: String,
    var tiny: String
) : Parcelable




