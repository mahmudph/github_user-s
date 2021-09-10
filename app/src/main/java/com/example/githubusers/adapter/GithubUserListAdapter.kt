package com.example.githubusers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.githubusers.databinding.ItemGithubUserBinding
import com.example.githubusers.model.GithubUsers
import com.example.githubusers.model.User

class GithubUserListAdapter(val githubUsers: GithubUsers):
    RecyclerView.Adapter<GithubUserListAdapter.ListViewAdapter>() {

    private lateinit var onClickItem: OnClickItemCallback

    companion object {
        private const val TAG = "GithubUserListAdapter"
    }

    interface OnClickItemCallback {
        fun onItemClicked(data: User)
    }

    fun setOnClickCallback(onClickCallback: OnClickItemCallback) {
        this.onClickItem = onClickCallback
    }

    inner class ListViewAdapter(private val binding: ItemGithubUserBinding): RecyclerView.ViewHolder(binding.root) {
        private fun getImage(imageName: String?): Int {
            return binding.root.context.resources.getIdentifier(imageName, "drawable", binding.root.context.packageName)
        }
        fun bind(data: User) {
            with(binding) {
                name.text = data.name
                location.text = data.location
                following.text = "${data.following} following"
                folower.text = "${data.follower} followers"
                Glide.with(itemView.context)
                    .load(getImage(data.avatar))
                    .apply(RequestOptions().override(55,55))
                    .into(imgItemPhoto)

                itemView.setOnClickListener {
                    onClickItem.onItemClicked(data)
                }
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewAdapter {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGithubUserBinding.inflate(inflater, parent, false)
        return ListViewAdapter(binding)
    }

    override fun onBindViewHolder(holder: ListViewAdapter, position: Int) {
        holder.bind(githubUsers.users[position])
    }

    override fun getItemCount(): Int {
        return githubUsers.users.size
    }
}