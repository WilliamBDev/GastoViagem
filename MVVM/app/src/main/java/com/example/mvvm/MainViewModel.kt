package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var textWelcome = MutableLiveData<String>()
    private var login = MutableLiveData<Boolean>()
    //o mutable->é dessa maneira que a view model e a activity consegue ententer as notificaçoes
    private val personRepository = PersonRepository()

    init {
        textWelcome.value = "Olá!"
    }

    fun welcome(): LiveData<String>{
        return textWelcome
    }

    fun login(): LiveData<Boolean>{
        return login
    }

    fun doLogin(email: String, password: String){
        login.value = personRepository.login(email, password)
    }
}
