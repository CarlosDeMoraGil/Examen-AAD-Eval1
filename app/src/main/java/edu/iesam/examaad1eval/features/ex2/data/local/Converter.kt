package edu.iesam.examaad1eval.features.ex2.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex2.domain.Player

class Converter {

    private val gson = Gson()

    @TypeConverter
    fun toEntity(players: List<Player>): String {
        return gson.toJson(players)
    }

    @TypeConverter
    fun fromEntity(players: String): List<Player> {
        return gson.fromJson(players, Array<Player>::class.java).toList()
    }

}