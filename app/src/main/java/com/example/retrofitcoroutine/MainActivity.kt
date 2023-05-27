package com.example.retrofitcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUserList()
    }

    private fun getUserList() {
        val retrofit = RetrofitClient.getInstance()
        val userService = retrofit.create(UserService::class.java)
        lifecycleScope.launch {
            try {
                val response = userService.getAllUsers()
                if (response.isSuccessful) {
                    val json = Gson().toJson(response.body())
                    Log.d(MainActivity::class.java.simpleName, json)
                } else {
                    Log.d(MainActivity::class.java.simpleName, "Error")
                }
            } catch (e: Exception) {
                Log.d(MainActivity::class.java.simpleName, "Error:" + e.message)
            }
        }
    }
}