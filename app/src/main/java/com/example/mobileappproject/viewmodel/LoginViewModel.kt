package com.example.mobileappproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileappproject.data.LoginResponse
import com.example.mobileappproject.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {

    // LiveData to observe login response
    val loginResult: MutableLiveData<LoginResponse?> = MutableLiveData()

    // Function to perform login operation
    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = loginRepository.login(username, password)
                if (response.isSuccessful) {
                    Log.d("LoginViewModel", "Login successful")
                    loginResult.postValue(response.body())
                } else {
                    Log.e("LoginViewModel", "Login failed with response code: ${response.code()}, message: ${response.message()}")
                    loginResult.postValue(null)  // Post null if login fails
                }
            } catch (e: Exception) {
                Log.e("LoginViewModel", "Login error: ${e.localizedMessage}")
                loginResult.postValue(null)  // Post null in case of an error
            }
        }
    }
}
