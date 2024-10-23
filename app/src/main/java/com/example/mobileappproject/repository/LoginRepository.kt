package com.example.mobileappproject.repository


import com.example.mobileappproject.data.LoginRequest
import com.example.mobileappproject.network.ApiService
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val apiService: ApiService
) {

    // Function to perform login API call
    suspend fun login(username: String, password: String) =
        try {
            // Call the API service with the login request
            apiService.login(LoginRequest(username, password))
        } catch (e: Exception) {
            // Handle any exceptions that might occur during the API call
            throw Exception("Login failed due to an error: ${e.message}")
        }
}
