package com.example.final_project_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    enum class LoginSuccess
            constructor(val intValue: Int){
                login(1),
                password(2),
                success(0)
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtLogin = findViewById<TextView>(R.id.idLoginTxt)
        val txtPassword = findViewById<TextView>(R.id.idPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            when(CheckLogin(txtLogin.text.toString(), txtPassword.text.toString())){
                LoginSuccess.login -> {
                    Toast.makeText(applicationContext, getString(R.string.errMsgLogin), Toast.LENGTH_LONG).show()
                    txtLogin.requestFocus()
                }
                LoginSuccess.password -> {
                    Toast.makeText(applicationContext, getString(R.string.errMsgPassword), Toast.LENGTH_LONG).show()
                    txtPassword.requestFocus()
                }
                else ->
                    Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()

            }
        }
    }

    fun CheckLogin(txtLogin: String, txtPassword: String): LoginSuccess{
        val holdLogin = "Sam"
        val holdPass = "password"

        if(holdLogin != txtLogin){
            return LoginSuccess.login
        }
        return if (holdPass != txtPassword){
            return LoginSuccess.password
        }else LoginSuccess.success
    }
}