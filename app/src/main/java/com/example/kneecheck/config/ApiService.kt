package com.example.kneecheck.config

import com.example.kneecheck.entity.BasicDRO
import com.example.kneecheck.entity.LoginDRO
import com.example.kneecheck.entity.loginDTO
import com.example.kneecheck.entity.registerDokterDTO
import com.example.kneecheck.entity.registerPasienDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

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
}
