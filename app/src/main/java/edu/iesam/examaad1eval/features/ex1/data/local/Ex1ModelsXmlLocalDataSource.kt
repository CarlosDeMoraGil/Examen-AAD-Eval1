package edu.iesam.examaad1eval.features.ex1.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex1.Item
import edu.iesam.examaad1eval.features.ex1.Services
import edu.iesam.examaad1eval.features.ex1.User

class Ex1ModelsXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        "db-exam", Context.MODE_PRIVATE
    )

    private val gson = Gson()
    private val editor = sharedPref.edit()

    fun findUsers(): List<User>? {
        return sharedPref.getString("users", null)?.let { list ->
            gson.fromJson(list, Array<User>::class.java)
        }?.toList()

    }

    fun saveUsers(users: List<User>) {
        editor.apply {

            putString("users", gson.toJson(users))

            apply()

        }

    }

    fun findItems(): List<Item>? {
        return sharedPref.getString("items", null)?.let { list ->
            gson.fromJson(list, Array<Item>::class.java)
        }?.toList()

    }

    fun saveItems(items: List<Item>) {
        editor.apply {

            putString("items", gson.toJson(items))

            apply()

        }

    }

    fun findServices(): List<Services>? {
        return sharedPref.getString("services", null)?.let { list ->
            gson.fromJson(list, Array<Services>::class.java)
        }?.toList()

    }

    fun saveServices(services: List<Services>) {
        editor.apply {

            putString("services", gson.toJson(services))

            apply()

        }

    }

    fun clear() {
        editor.clear().apply()
    }


}