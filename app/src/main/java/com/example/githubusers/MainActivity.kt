package com.example.githubusers

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.adapter.GithubUserListAdapter
import com.example.githubusers.databinding.ActivityMainBinding
import com.example.githubusers.model.GithubUsers
import com.example.githubusers.model.User
import com.example.githubusers.utils.GeneralUtils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var activityBinding: ActivityMainBinding
    private lateinit var githubUsersList: RecyclerView
    private lateinit var githubUsers: GithubUsers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)

        supportActionBar?.title = "Github User's"

        githubUsersList = activityBinding.githubUserList

        githubUsersList.setHasFixedSize(true)

        var jsonText = GeneralUtils.readJsonFile(applicationContext)
        githubUsers = GeneralUtils.parsingJsonFile(jsonText)
        showGithubUsersLists()
    }

    private fun showGithubUsersLists() {
        githubUsersList.layoutManager = LinearLayoutManager(this)
        val listGithubUsers = GithubUserListAdapter(githubUsers)
        githubUsersList.adapter = listGithubUsers

        listGithubUsers.setOnClickCallback(object: GithubUserListAdapter.OnClickItemCallback {
            override fun onItemClicked(data: User) {
                navigateToDetailUser(data)
            }
        })
    }

    private fun navigateToDetailUser(data: User) {
        val detailUsers = Intent(this, ProfileActivity::class.java)
        detailUsers.putExtra(ProfileActivity.TAG, data)
        startActivity(detailUsers)
    }
}