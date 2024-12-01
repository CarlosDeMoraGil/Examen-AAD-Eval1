package edu.iesam.examaad1eval.features.ex1.data

import edu.iesam.examaad1eval.features.ex1.Ex1ModelsMockRemoteDataSource
import edu.iesam.examaad1eval.features.ex1.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.Item
import edu.iesam.examaad1eval.features.ex1.Services
import edu.iesam.examaad1eval.features.ex1.User
import edu.iesam.examaad1eval.features.ex1.data.local.Ex1ModelsXmlLocalDataSource

class Ex1ModelDataRepository(
    private val remote: Ex1ModelsMockRemoteDataSource,
    private val local: Ex1ModelsXmlLocalDataSource
) : Ex1Repository {

    override fun getUsers(): List<User> {
        val localData = local.findUsers()

        return if (localData != null) {
            localData

        } else {
            val remoteData = remote.getUsers()
            local.saveUsers(remoteData)

            remoteData
        }
    }

    override fun getItems(): List<Item> {
        val localData = local.findItems()

        return if (localData != null) {
            localData

        } else {
            val remoteData = remote.getItems()
            local.saveItems(remoteData)

            remoteData
        }
    }

    override fun getServices(): List<Services> {
        val localData = local.findServices()

        return if (localData != null) {
            localData

        } else {
            val remoteData = remote.getServices()
            local.saveServices(remoteData)

            remoteData
        }
    }

}