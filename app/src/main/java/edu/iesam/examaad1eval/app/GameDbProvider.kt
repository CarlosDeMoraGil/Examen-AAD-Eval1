package edu.iesam.examaad1eval.app

import android.content.Context
import androidx.room.Room
import edu.iesam.examaad1eval.app.data.local.GameDataBase

class GameDbProvider(private val context: Context) {

    fun provideDb(): GameDataBase {
        val db = Room.databaseBuilder(
            context,
            GameDataBase::class.java, "GAMES"
        ).fallbackToDestructiveMigration()
            .build()

        return db
    }

}