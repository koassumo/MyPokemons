//package com.example.mypokemons.mvp.model.entity.room.dao
//
//import androidx.room.*
//import com.example.mypokemons.mvp.model.entity.room.RoomRepo
//import com.example.mypokemons.mvp.model.entity.room.RoomUserPokemonSpecies
//
//@Dao
//interface RepositoryDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(user: RoomRepo)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(vararg users: RoomRepo)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(users: List<RoomRepo>)
//
//    @Update
//    fun update(user: RoomRepo)
//
//    @Update
//    fun update(vararg users: RoomRepo)
//
//    @Update
//    fun update(users: List<RoomRepo>)
//
//    @Delete
//    fun delete(user: RoomRepo)
//
//    @Delete
//    fun delete(vararg users: RoomRepo)
//
//    @Delete
//    fun delete(users: List<RoomRepo>)
//
//    @Query("SELECT * FROM RoomRepo")
//    fun getAll(): List<RoomRepo>
//
//    @Query("SELECT * FROM RoomRepo WHERE name = :userId")
//    fun findForUser(userId: String): List<RoomRepo>
//
//}