package com.example.githubusers
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubusers.databinding.ActivityProfileBinding
import com.example.githubusers.model.User

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    companion object {
        const val TAG = "ProfileActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Detail User"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        getFromParcelData()
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun getImage(imageName: String?): Int {
        return binding.root.context.resources.getIdentifier(imageName, "drawable", binding.root.context.packageName)
    }

    private fun getFromParcelData() {
        val user = intent.getParcelableExtra<User>(TAG)!!
        binding.username.text = "${user.username}"
        binding.nameUser.text = user.name
        binding.userLocation.text = user.location
        binding.follower.text = user.follower.toString()
        binding.following.text = user.following.toString()
        binding.imgItemPhoto.setImageResource(getImage(user.avatar))
        binding.companyValue.text = user.company
        binding.repositoryvalue.text = user.repository.toString()
    }
}