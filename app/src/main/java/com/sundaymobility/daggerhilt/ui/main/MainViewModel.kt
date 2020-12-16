package com.sundaymobility.daggerhilt.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sundaymobility.daggerhilt.data.model.User
import com.sundaymobility.daggerhilt.data.repository.MainRepository
import com.sundaymobility.daggerhilt.utils.NetworkHelper
import com.sundaymobility.daggerhilt.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val networkHelper: NetworkHelper,
    private val repository: MainRepository
) : ViewModel() {

    //init
    private var _users = MutableLiveData<Resource<List<User>>>()
    val user: LiveData<Resource<List<User>>>
        get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isConnected()) {
                repository.getUser().let {
                    if (it.isSuccessful) {
                        _users.postValue(Resource.success(it.body()))
                    } else _users.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _users.postValue(Resource.error("No internet connection", null))
        }
    }

}