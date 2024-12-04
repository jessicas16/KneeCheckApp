package com.example.kneecheck.dokter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import okhttp3.MultipartBody

class ScanViewModel(private val repository: ScanRepository) : ViewModel() {
    private val _scanResult = MutableLiveData<ScanResultResponse>()
    val scanResult: LiveData<ScanResultResponse> = _scanResult

    fun uploadImage(img: MultipartBody.Part) {
        viewModelScope.launch {
            try {
                val response = repository.uploadImage(img)
                _scanResult.postValue(response)
            } catch (e: Exception) {
                Log.e("ScanViewModel", "Error: ${e.message}")
            }
        }
    }
}
