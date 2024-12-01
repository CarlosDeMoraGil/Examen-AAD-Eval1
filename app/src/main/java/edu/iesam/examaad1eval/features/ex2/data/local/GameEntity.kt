package edu.iesam.examaad1eval.features.ex2.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import edu.iesam.examaad1eval.features.ex2.domain.Player

const val TABLE_NAME = "games"
const val GAME_ID = "id"

@Entity(tableName = TABLE_NAME)
data class GameEntity(
    @PrimaryKey @ColumnInfo(name = GAME_ID) val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "player") val player: List<Player>
)