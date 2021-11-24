package com.example.calccmodule.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calccmodule.model.UserModel
import com.example.calccmodule.module.MainRepository
import com.example.calccmodule.module.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
public class HomeViewModel @Inject constructor(
     val mainRepository: MainRepository,
     val networkHelper: NetworkHelper
) : ViewModel() {
    // TODO: Implement the ViewModel
    private val _users = MutableLiveData<List<UserModel>>()
    val users: LiveData<List<UserModel>>
        get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            // _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getUsers().let {
                    if (it.isSuccessful) {
                        //_users.postValue(Resource.success(it.body()))
                    } //else _users.postValue(Resource.error(it.errorBody().toString(), null))
                }
            }
        }
    }
}