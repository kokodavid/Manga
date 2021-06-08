package com.koko.manga.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koko.manga.model.FootballModel
import com.koko.manga.services.FootballApi
import kotlinx.coroutines.launch

class FootballViewModel: ViewModel(){

    init{
        getFootball()
    }

    private val _footballData = MutableLiveData<List<FootballModel>>()
    private val _status = MutableLiveData<String>()
    val footballData : LiveData<List<FootballModel>> = _footballData
    val status: LiveData<String> = _status

    private fun getFootball(){
        viewModelScope.launch {
            try {
                _footballData.value = FootballApi.retrofitService.getGames()
                _status.value = "Success: Retrieved Data"
            }catch (e: Exception){
                _status.value = "Failure: ${e.message}"
            }
        }
    }


}