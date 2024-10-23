package com.example.mobileappproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileappproject.data.DashboardResponse
import com.example.mobileappproject.repository.DashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val dashboardRepository: DashboardRepository
) : ViewModel() {

    // LiveData to observe dashboard data
    private val _dashboardData = MutableLiveData<DashboardResponse?>()
    val dashboardData: LiveData<DashboardResponse?> get() = _dashboardData

    // Function to fetch dashboard data using the keypass
    fun getDashboardData(keypass: String) {
        viewModelScope.launch {
            try {
                val response = dashboardRepository.getDashboardData(keypass)
                if (response.isSuccessful) {
                    _dashboardData.postValue(response.body())
                } else {
                    _dashboardData.postValue(null)  // Handle failure by posting null
                }
            } catch (e: Exception) {
                _dashboardData.postValue(null)  // Post null on failure
            }
        }
    }
}