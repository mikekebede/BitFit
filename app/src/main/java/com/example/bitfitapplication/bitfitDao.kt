package com.example.bitfitapplication


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BitfitDao {
    @Query("SELECT * FROM calorie_table")
    fun getAll(): Flow<List<BitfitEntity>>
    @Insert
    fun insert(bitfitentity: BitfitEntity)
    @Query("DELETE FROM calorie_table")
    fun deleteAll()
}