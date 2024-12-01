package edu.iesam.examaad1eval

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.app.GameDbProvider
import edu.iesam.examaad1eval.features.ex2.data.GamesDataRepository
import edu.iesam.examaad1eval.features.ex2.data.local.GameDbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.GameMockRemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        executeExercise2()

    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2(){
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        GlobalScope.launch {

            val local = GameDbLocalDataSource(
                GameDbProvider(this@MainActivity).provideDb().proviceGameDao()
            )

            val remote = GameMockRemoteDataSource()

            val dataRepository = GamesDataRepository(remote, local)

            val games = dataRepository.getGames()

            Log.d("@dev", games.toString())

        }
    }
}