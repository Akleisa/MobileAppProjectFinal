package com.example.mobileappproject.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.w3c.dom.Entity
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {

    // LiveData to observe selected entity details
    val selectedEntity: MutableLiveData<Entity> = MutableLiveData()

    // Function to set selected entity
    fun setEntity(entity: Entity) {
        selectedEntity.value = entity
    }
}
