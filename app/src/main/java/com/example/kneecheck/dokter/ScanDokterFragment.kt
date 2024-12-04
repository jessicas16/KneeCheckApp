package com.example.kneecheck.dokter

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kneecheck.R
import com.example.kneecheck.databinding.FragmentScanDokterBinding
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class ScanDokterFragment : Fragment() {

    private lateinit var viewModel: ScanViewModel
    private lateinit var binding: FragmentScanDokterBinding
    private var selectedImageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize ViewBinding
        binding = FragmentScanDokterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = ScanRepository(ApiConfig.getApiService())
        viewModel = ViewModelProvider(this, ViewModelFactory(repository))[ScanViewModel::class.java]

        binding.galleryButton.setOnClickListener {
            openGallery()
        }

        binding.checkButton.setOnClickListener {
            selectedImageUri?.let { uri ->
                val file = File(getRealPathFromURI(uri))
                val requestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
                val imagePart = MultipartBody.Part.createFormData("img", file.name, requestBody)

                viewModel.uploadImage(imagePart)
            }
        }

        viewModel.scanResult.observe(viewLifecycleOwner) { result ->
            val bundle = Bundle().apply {
                putFloat("confidenceScore", result.confidenceScore)
                putString("label", result.label)
                putString("id_xray", result.id_xray)
                putString("img_path", result.img_path)
                putString("pengobatan", result.pengobatan)
            }
            findNavController().navigate(R.id.action_scan_to_result, bundle)
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GALLERY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            selectedImageUri = data?.data
        }
    }

    private fun getRealPathFromURI(uri: Uri): String {
        var path = ""
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = context?.contentResolver?.query(uri, projection, null, null, null)
        cursor?.use {
            if (it.moveToFirst()) {
                val columnIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                path = it.getString(columnIndex)
            }
        }
        return path
    }

    companion object {
        private const val GALLERY_REQUEST_CODE = 100
    }
}
