package edu.iesam.examaad1eval

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.features.ex1.Ex1ModelsMockRemoteDataSource
import edu.iesam.examaad1eval.features.ex1.data.Ex1ModelDataRepository
import edu.iesam.examaad1eval.features.ex1.data.local.Ex1ModelsXmlLocalDataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        executeExercise1()

    }

    private fun executeExercise1() {
        val localDataSource = Ex1ModelsXmlLocalDataSource(this)
        val remoteDataSource = Ex1ModelsMockRemoteDataSource()

        val dataRepository = Ex1ModelDataRepository(remoteDataSource, localDataSource)

        val users = dataRepository.getUsers()
        val items = dataRepository.getItems()
        val services = dataRepository.getServices()

        Log.d("@dev", users.toString())
        Log.d("@dev", items.toString())
        Log.d("@dev", services.toString())

    }


}