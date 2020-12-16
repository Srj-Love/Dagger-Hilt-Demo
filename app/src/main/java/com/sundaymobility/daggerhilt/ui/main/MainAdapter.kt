package com.sundaymobility.daggerhilt.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sundaymobility.daggerhilt.R
import com.sundaymobility.daggerhilt.data.model.User
import com.sundaymobility.daggerhilt.databinding.ItemLayoutBinding

class MainAdapter(
    private val users: ArrayList<User>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    inner class DataViewHolder(private var vb: ItemLayoutBinding) : RecyclerView.ViewHolder(vb.root) {

        fun bind(user: User) {
            val color = arrayListOf(R.color.place_1, R.color.place_2, R.color.place_3, R.color.place_4).random()

            with(vb){
                textViewUserName.text = user.name
                textViewUserEmail.text = user.email
                Glide.with(imageViewAvatar.context)
                    .load(user.avatar)
                    .placeholder(color)
                    .error(color)
                    .into(imageViewAvatar)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val item = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(item)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])

    fun addData(list: List<User>) {
        users.addAll(list)
    }
}