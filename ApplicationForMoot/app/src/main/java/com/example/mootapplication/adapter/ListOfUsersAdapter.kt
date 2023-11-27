package com.example.mootapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.mootapplication.adapter.comparator.ListOfUsersComparator
import com.example.mootapplication.adapter.viewHolder.ListOfUsersViewHolder
import com.example.mootapplication.data.entities.RegisterUser
import com.example.mootapplication.databinding.ItemUserBinding

class AddressAdapter(

) : ListAdapter<RegisterUser, ListOfUsersViewHolder>(ListOfUsersComparator) {

    override fun getItemCount() = currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListOfUsersViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )

    override fun onBindViewHolder(holder: ListOfUsersViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}
