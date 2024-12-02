package com.example.kneecheck.config

import android.util.Log
import com.example.kneecheck.entity.BasicDRO
import com.example.kneecheck.entity.loginDTO

class DefaultRepo (
    private val dataSourceRemote : ApiService,
) {
    suspend fun getAllUser() : BasicDRO {
        Log.e("DefaultRepo", dataSourceRemote.getAllUser().toString())
        return dataSourceRemote.getAllUser()
    }

    suspend fun login(user : loginDTO): Any {
        Log.e("DefaultRepo result", dataSourceRemote.login(user).toString())
        return dataSourceRemote.login(user)
    }
}