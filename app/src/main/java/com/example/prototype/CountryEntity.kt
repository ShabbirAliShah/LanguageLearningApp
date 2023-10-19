package com.example.prototype

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class CountryEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var country: String? = null,
    var language: String? = null,
    var no: Int? = null
)
