package com.example.tmdbclient.data.model.artistModel
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName= "popular_Artists" )
data class Artist(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    //@ColumnInfo(name ="")
    @SerializedName("name")
    val name: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String
)