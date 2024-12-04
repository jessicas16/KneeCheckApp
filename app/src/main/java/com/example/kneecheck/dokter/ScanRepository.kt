package com.example.kneecheck.dokter

import com.example.kneecheck.config.ApiService
import okhttp3.MultipartBody

class ScanRepository(private val apiService: ApiService) {
    suspend fun uploadImage(img: MultipartBody.Part): ScanResultResponse {
        val response = apiService.predictXRay(img)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception("Error: ${response.message()}")
        }
    }
}
