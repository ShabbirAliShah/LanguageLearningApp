package com.example.prototype

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CountryDao {
    @Insert
    suspend fun insert(country: CountryEntity)

    @Delete
    suspend fun delete(country: CountryEntity)

    @Query("SELECT * FROM countries")
    suspend fun getAllCountries(): List<CountryEntity>
}
