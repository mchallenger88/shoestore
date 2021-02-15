package com.udacity.shoestore.login

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber


class LoginViewModel : ViewModel() {

    val email = ObservableField<String>("mark@na.com")
    val password = ObservableField<String>("Test")

    private val _showError = MutableLiveData<Boolean>()
    val showError: LiveData<Boolean>
        get() = _showError

    private val _loginComplete = MutableLiveData<Boolean>()
    val loginComplete: LiveData<Boolean>
        get() = _loginComplete


    init{
//        _email.value = "mark@na.com"
        _showError.value = false
        _loginComplete.value = false
    }

    fun validateCredentials(){
        //TODO: Check credentials repository

        var passwordValid: Boolean = (email.get() == "mark@na.com" && password.get() == "Test")

        _showError.value = !passwordValid
        _loginComplete.value = true

    }

    fun onLoginValidated(){
        _loginComplete.value = true
    }




}