package com.example.mvvmstudy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

//ViewModelProvider로 ViewModel객체를 만들때 초기 값을 전달하는 것이 금지되어있으므로 Factory 패턴을 사용한다.
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val counter: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(counter) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}

