package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.buttonLogin.setOnClickListener(this)

        setObserver()
    }

    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.button_login){
                val email = binding.edtEmail.text.toString()
                val password = binding.edtPassword.toString()

                viewModel.doLogin(email, password)
            }
        }
    }


    private fun setObserver() {
        viewModel.welcome().observe(this, Observer {
            binding.textWelcome.text = it
        })
        viewModel.login().observe(this, Observer {
            if(it){
                Toast.makeText(applicationContext, "SUCESSO!", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext, "FALHA!", Toast.LENGTH_LONG).show()
            }
        })
    }


}
