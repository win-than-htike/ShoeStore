package com.winthan.shoestore.screens.login

import android.app.Application
import androidx.lifecycle.*

sealed class LoginEvent {
    object Login: LoginEvent()
    object Register: LoginEvent()
    object IDLE: LoginEvent()
}

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val _email = MutableLiveData("")
    private val email: LiveData<String>
        get() = _email

    private val _password = MutableLiveData("")
    private val password: LiveData<String>
        get() = _password

    private val _loginEvent = MutableLiveData<LoginEvent>()
    val loginEvent : LiveData<LoginEvent>
        get() = _loginEvent

    fun login(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginEvent.value = LoginEvent.Login
    }

    fun register(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginEvent.value = LoginEvent.Register
    }

    fun onFinishLogin() {
        _loginEvent.value = LoginEvent.IDLE
    }

}