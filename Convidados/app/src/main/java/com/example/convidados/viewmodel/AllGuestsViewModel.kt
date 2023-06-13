package com.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.convidados.model.GuestModel
import com.example.convidados.repository.GuestRepository

class AllGuestsViewModel(application: Application): AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application.applicationContext)

    private val listAllGuest = MutableLiveData<List<GuestModel>>()

    val guests: LiveData<List<GuestModel>> = listAllGuest

    fun getAll(){
        listAllGuest.value = repository.getAll()
    }
}