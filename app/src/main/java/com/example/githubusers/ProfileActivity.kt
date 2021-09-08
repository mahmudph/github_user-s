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
        supportActionBar?.title = "Detai User"
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
        var user = intent.getParcelableExtra<User>(TAG)!!
        binding.nameUser.text = "${user!!.username?.get(0)!!.toUpperCase()}${user!!.username!!.substring(2)}"
        binding.userLocation.text = user!!.location
        binding.follower.text = user.follower.toString()
        binding.following.text = user!!.following.toString()
        binding.imgItemPhoto.setImageResource(getImage(user.avatar))
    }
}