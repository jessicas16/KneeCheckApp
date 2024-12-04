package com.example.kneecheck.dokter

data class ScanResultResponse(
    val confidenceScore: Float,
    val label: String,
    val id_xray: String,
    val img_path: String,
    val pengobatan: String
)
