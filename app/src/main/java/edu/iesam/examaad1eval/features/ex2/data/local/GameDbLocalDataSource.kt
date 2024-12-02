package edu.iesam.examaad1eval.features.ex2.data.local

import edu.iesam.examaad1eval.features.ex2.domain.Game

class GameDbLocalDataSource(private val dao: GameDao) {

    fun saveAll(games: List<Game>) {

        games.map {
            dao.saveAll(it.toEntity())
        }

    }

    fun deleteAll() {
        dao.deleteAll()
    }

}