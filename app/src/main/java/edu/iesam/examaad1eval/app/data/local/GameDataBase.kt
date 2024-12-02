package edu.iesam.examaad1eval.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.iesam.examaad1eval.features.ex2.data.local.Converter
import edu.iesam.examaad1eval.features.ex2.data.local.GameDao
import edu.iesam.examaad1eval.features.ex2.data.local.GameEntity

@Database(entities = [GameEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class GameDataBase : RoomDatabase() {

    abstract fun proviceGameDao(): GameDao

}