package com.example.githubusers.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var avatar: String? = "",
    var company: String? = "",
    var follower: Int = 0,
    var following: Int = 0,
    var location: String? = "",
    var name: String? = "",
    var repository: Int = 0,
    var username: String? = ""
): Parcelable
