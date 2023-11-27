package com.example.mootapplication.ui.views.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mootapplication.R
import com.example.mootapplication.databinding.FragmentListOfUserFragmentBinding
import com.example.mootapplication.ui.viewModels.ListOfUserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListOfUsersFragment : Fragment(R.layout.fragment_list_of_user_fragment) {
    private lateinit var binding: FragmentListOfUserFragmentBinding
   val viewModel: ListOfUserViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListOfUserFragmentBinding.bind(view)
        binding.fragment = this@ListOfUsersFragment

        setUpRecycleView()
        setUpObservers()
    }

    private fun setUpRecycleView() {
        try {
        } catch (e: Exception) {

        }
    }

    private fun setUpObservers() {
        viewModel
    }

    fun goToRegisterUserFromListOfUsers() {
        val navController = findNavController()
        navController.navigate(R.id.action_listOfUsersFragment_to_registerUserFragment)
    }

}
