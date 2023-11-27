package com.example.mootapplication.adapter.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.mootapplication.data.entities.RegisterUser
import com.example.mootapplication.databinding.ItemUserBinding


class ListOfUsersViewHolder(val view: ItemUserBinding) :
    RecyclerView.ViewHolder(view.root) {

    fun bind(
        item: RegisterUser,
    ) = with(view) {

    }
}
