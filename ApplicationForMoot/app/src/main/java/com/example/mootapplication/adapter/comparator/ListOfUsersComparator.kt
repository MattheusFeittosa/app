package com.example.mootapplication.adapter.comparator

import androidx.recyclerview.widget.DiffUtil
import com.example.mootapplication.data.entities.RegisterUser


object ListOfUsersComparator : DiffUtil.ItemCallback<RegisterUser>() {
    override fun areItemsTheSame(
        oldItem: RegisterUser,
        newItem: RegisterUser
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: RegisterUser, newItem: RegisterUser): Boolean {
        return oldItem == newItem
                oldItem== newItem
    }
}
