package com.example.mypokemons.mvp.model.entity.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
//import com.example.mypokemons.mvp.model.entity.room.dao.RepositoryDao
import com.example.mypokemons.mvp.model.entity.room.dao.UserPokemonDao
import java.lang.RuntimeException

//@androidx.room.Database (entities = [RoomUserPokemonSpecies::class, RoomRepo::class], version = 1)
@androidx.room.Database (entities = [RoomUserPokemonSpecies::class], version = 1)
abstract class Database : RoomDatabase () {
    abstract val userPokemonDao: UserPokemonDao
    //abstract val repositoryDao: RepositoryDao


    companion object {
        private const val DB_NAME = "database.db"
        private var instance: Database? = null

        fun getInstance() = instance ?: throw RuntimeException("База данных не создана")

        fun create(context: Context) {
            if (instance == null) {
                instance = Room.databaseBuilder(context!!, Database::class.java, DB_NAME).build()
            }
        }
    }
}