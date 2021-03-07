package com.example.mypokemons.mvp.model.entity.room.dao

import androidx.room.*
import com.example.mypokemons.mvp.model.entity.room.RoomUserPokemonSpecies

@Dao
interface UserPokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: RoomUserPokemonSpecies)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: RoomUserPokemonSpecies)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<RoomUserPokemonSpecies>)

    @Update
    fun update(user: RoomUserPokemonSpecies)

    @Update
    fun update(vararg users: RoomUserPokemonSpecies)

    @Update
    fun update(users: List<RoomUserPokemonSpecies>)

    @Delete
    fun delete(user: RoomUserPokemonSpecies)

    @Delete
    fun delete(vararg users: RoomUserPokemonSpecies)

    @Delete
    fun delete(users: List<RoomUserPokemonSpecies>)

    @Query("SELECT * FROM RoomUserPokemonSpecies")
    fun getAll() : List<RoomUserPokemonSpecies>

    @Query("SELECT * FROM RoomUserPokemonSpecies WHERE name = :login LIMIT 1") //   выбор по полю name
    fun findByLogin(login : String) : RoomUserPokemonSpecies
}