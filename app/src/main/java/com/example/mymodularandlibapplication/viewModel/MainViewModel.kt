package com.example.mymodularandlibapplication.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.calccmodule.model.UserModel
import com.example.calccmodule.module.MainRepository
import com.example.calccmodule.module.NetworkHelper
import com.example.mymodularandlibapplication.Adapter.UserAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    // TODO: Implement the ViewModel
    private lateinit var adapter: UserAdapter
    private val _users = MutableLiveData<UserModel>()
    val users: LiveData<UserModel>
        get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() : MutableLiveData<UserModel>{
        viewModelScope.launch {
            // _users.postValue(Resource.loading(null))
//            if (networkHelper.isNetworkConnected()) {
                mainRepository.getUsers().let {
                    if (it.isSuccessful) {
                       // val dataResponse = response.body() as UserModel
                        _users.postValue(it.body())
                        val dataResponse=it.body()as UserModel
                        Log.d("TAG", "onResponse: "+dataResponse)

                        //_users.postValue(Resource.success(it.body()))
                    } //else _users.postValue(Resource.error(it.errorBody().toString(), null))
               // }
            }
        }
        return _users
    }
}