package com.example.githubusers.utils

import android.content.Context
import com.example.githubusers.model.GithubUsers
import com.google.gson.Gson

object GeneralUtils {
    fun readJsonFile(context: Context): String {
        val fileName = "githubuser.json"
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }
    fun parsingJsonFile(jsonText: String): GithubUsers {
        return Gson().fromJson(jsonText, GithubUsers::class.java)
    }

}