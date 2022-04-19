package com.example.edvoraassignment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edvoraassignment.Model.RideResponseItem
import com.example.edvoraassignment.Model.UserResponse
import kotlinx.coroutines.launch
import java.util.ArrayList

class MainViewModel: ViewModel() {
    val repo = MainRepo()
    val livedata = MutableLiveData<ArrayList<RideResponseItem>>()
    val UserLiveData = MutableLiveData<UserResponse>()
    fun getUser() = viewModelScope.launch {
        try {
          val response =   repo.api.getUser()
            if(response.isSuccessful){
                UserLiveData.postValue(response.body())
            }
        }
        catch (e:Exception){
            Log.d("error",e.toString())
        }
    }
    fun getRides() = viewModelScope.launch {
        try{
            val response = repo.api.getRides()
            if(response.isSuccessful){
                livedata.postValue(response.body())
            }
        }
        catch (e:Exception){
            Log.d("error2",e.toString())
        }
    }
}