//package com.example.mypokemons.mvp.model.entity.room
//
//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.ForeignKey
//import androidx.room.PrimaryKey
//import com.google.gson.annotations.Expose
//import com.google.gson.annotations.SerializedName
//
//// здесь устанавливается связь по внешнему ключу с родительской таблицей
//@Entity(
//    foreignKeys = [ForeignKey(
//        entity = RoomUserPokemonSpecies::class, // основная таблица
//        parentColumns = ["id"],                 // поле в основной таблице
//        childColumns = ["userForeignId"],       // поле в дочерней таблице
//        onDelete = ForeignKey.CASCADE           // логика удаления каскадон - удаляет все дочерние сущности за собой
//    )]
//)
//
//
//// Дочерняя таблица
//data class RoomRepo(
//
//    @PrimaryKey
//    @Expose
//    @ColumnInfo(name = "name")
//    var pokemonName: String,
//
//    @Expose
//    @ColumnInfo(name = "url")
//    var pokemonUrl: String,
//
//    @Expose
//    var userForeignKey: String
//)