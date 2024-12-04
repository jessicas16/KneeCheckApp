package com.example.kneecheck.config

import com.example.kneecheck.dokter.ScanResultResponse
import com.example.kneecheck.entity.BasicDRO
import com.example.kneecheck.entity.LoginDRO
import com.example.kneecheck.entity.dashboardDokterData
import com.example.kneecheck.entity.loginDTO
import com.example.kneecheck.entity.registerDokterDTO
import com.example.kneecheck.entity.registerPasienDTO
import com.example.kneecheck.pasien.LandingPageResponse
import okhttp3.MultipartBody
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.Part

interface ApiService {
    @GET("users")
    suspend fun getAllUser():BasicDRO

    @POST("login")
    suspend fun login(
        @Body user : loginDTO
    ): LoginDRO

    @POST("register/pasien")
    suspend fun registerPasien(
        @Body regPasien : registerPasienDTO
    ): Any

    @POST("register/dokter")
    suspend fun registerDokter(
        @Body regDokter : registerDokterDTO
    ): Any

    @GET("dashboard")
    suspend fun getDashboard(
        @Header("Authorization") token: String
    ): dashboardDokterData

    @GET("landing-page")
    suspend fun getLandingPage(): LandingPageResponse

    @Multipart
    @POST("predict")
    suspend fun predictXRay(
        @Part img: MultipartBody.Part
    ): Response<ScanResultResponse>

}
