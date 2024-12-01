package edu.iesam.examaad1eval.features.ex2.data

import edu.iesam.examaad1eval.features.ex2.data.local.GameDbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.GameMockRemoteDataSource
import edu.iesam.examaad1eval.features.ex2.domain.Game
import edu.iesam.examaad1eval.features.ex2.domain.GameRepository

class GamesDataRepository(
    private val remoteDataSource: GameMockRemoteDataSource,
    private val localDataSource: GameDbLocalDataSource
) : GameRepository {

    override fun getGames(): List<Game> {
        val remoteData = remoteDataSource.getGames()

        return if (remoteData.isEmpty()) {
            emptyList()
        } else {
            localDataSource.saveAll(remoteData)
            remoteData
        }

    }
}