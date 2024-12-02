package edu.iesam.examaad1eval.features.ex2.data

import android.util.Log
import edu.iesam.examaad1eval.features.ex2.data.local.GameDbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.GameMockRemoteDataSource
import edu.iesam.examaad1eval.features.ex2.domain.Game
import edu.iesam.examaad1eval.features.ex2.domain.GameRepository

class GamesDataRepository(
    private val remoteDataSource: GameMockRemoteDataSource,
    private val localDataSource: GameDbLocalDataSource
) : GameRepository {

    override fun getGames(): List<Game> {
        localDataSource.deleteAll()
        val remoteData = remoteDataSource.getGames()

        return if (remoteData.isEmpty()) {
            emptyList()
        } else {

            // OBETNEMOS 5
            var cont = 0
            val local5 = ArrayList<Game>()

            while (cont != 5) {
                local5.add(remoteData.get(cont))
                cont++
            }

            Log.d("@dev", local5.toString())

            // OBETNEMOS 2
            val local3 = ArrayList<Game>()

            local3.addAll(remoteData.filterNot {
                it in local5
            })

            // JUNTAMOS AMBAS
            local5.addAll(local3)

            localDataSource.saveAll(local5)
            local5

        }

    }
}