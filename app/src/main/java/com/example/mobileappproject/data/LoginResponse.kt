package com.example.mobileappproject.data

import com.squareup.moshi.Json

data class LoginResponse(
    @Json(name = "keypass") val keypass: String
)