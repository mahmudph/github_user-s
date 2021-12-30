package com.example.githubusers.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UsersViewModel: ViewModel() {
    private lateinit var userFollowing: MutableLiveData<String>
    private lateinit var userFollowers: MutableLiveData<String>

    var usersFollowing = userFollowing
    var usersFollowers = userFollowers


    fun getUserFollowing() {

    }

}