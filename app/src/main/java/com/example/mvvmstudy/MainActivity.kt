package com.example.mvvmstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //viewModel 선언
    private lateinit var viewModel: MainViewModel
    //viewBinding 선언
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding 객체 생성
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //ViewModel 객체를 그냥 생성하면 경우에 따라 여러개 만들어지는 문제가 발생
        //따라서 ViewModelProvider를 통해 객체를 Singleton으로 생성
        //Activity가 ViewModel에서 데이터를 가지고 올수 있게 됨
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val factory = ViewModelFactory(100)
        val viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        binding.num.text = viewModel.getCount().toString()

        binding.plus.setOnClickListener {
            viewModel.plus()
            binding.num.text = viewModel.getCount().toString()
        }

        binding.minus.setOnClickListener {
            viewModel.minus()
            binding.num.text = viewModel.getCount().toString()
        }
    }
}