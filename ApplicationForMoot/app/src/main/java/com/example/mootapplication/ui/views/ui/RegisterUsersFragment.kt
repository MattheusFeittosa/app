package com.example.mootapplication.ui.views.ui

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mootapplication.R
import com.example.mootapplication.databinding.RegisterUserFragmentBinding
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterUsersFragment : Fragment(R.layout.register_user_fragment) {

    private lateinit var binding: RegisterUserFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = RegisterUserFragmentBinding.bind(view)
        binding.fragment = this@RegisterUsersFragment
    }

    fun backToListOfUsersAndNotRegisterUser() {
        val navController = findNavController()
        navController.popBackStack()
    }

    fun registerUserAndGoBackToListOfUsers() {
        val navController = findNavController()
        navController.popBackStack()
    }

    fun verifyPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            openCamera()
        } else {
            requestPermission()
        }
    }

    private fun requestPermission(
    ) {
        var allDone = true
        val status = ContextCompat.checkSelfPermission(
            requireActivity(),
            Manifest.permission.CAMERA,
        ) == PackageManager.PERMISSION_GRANTED
        if (!status) {
            allDone = false
        }

        if (!allDone) {
            showPermissionAlertDialog()
        } else {
            openCamera()
        }

    }

    private fun showPermissionAlertDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Permissão Necessária")
        builder.setMessage("A permissão da câmera é necessária para tirar fotos. Por favor, conceda a permissão nas configurações do aplicativo.")
        builder.setPositiveButton("Configurações") { dialog, which ->
            val settingsIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            val uri = Uri.fromParts(
                "package",
                requireActivity().packageName, null
            )
            settingsIntent.data = uri
            startActivity(settingsIntent)
        }
        builder.setNegativeButton("Cancelar") { dialog, which ->
            Toast.makeText(
                requireContext(),
                "Permissão da câmera foi negada.", Toast.LENGTH_SHORT
            )
                .show()

            dialog.dismiss()
        }
        builder.show()
    }

    private fun openCamera() {
        val intent = Intent("android.media.action.IMAGE_CAPTURE")
        startActivity(intent)
    }
}