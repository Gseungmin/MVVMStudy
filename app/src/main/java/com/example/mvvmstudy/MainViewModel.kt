package com.example.mvvmstudy

import androidx.lifecycle.ViewModel

//ViewModel을 상속받음
class MainViewModel(
    _counter : Int
) : ViewModel() {

    //ViewModel에서 관리하는 변수
    var countValue = _counter

    fun plus(){
        countValue++
    }

    fun minus(){
        countValue--
    }

    fun getCount() : Int {
        return countValue
    }
}