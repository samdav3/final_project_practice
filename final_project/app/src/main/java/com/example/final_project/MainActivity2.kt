package com.example.final_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckedTextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val confirmBets = findViewById<Button>(R.id.confirmBtn)
        val backBtn = findViewById<Button>(R.id.BckBtn)
        val bet1 = findViewById<CheckedTextView>(R.id.ChkTextBet1)
        val bet2 = findViewById<CheckedTextView>(R.id.ChkTextBet2)

        val isChecked = this.intent.getBooleanExtra("checkBoxValue", false).toString()
        //val isChecked2 = this.intent.getBooleanExtra("checkBoxValue", false).toString()
        //val isChecked3 = this.intent.getBooleanExtra("checkBoxValue", false).toString()
        //val isChecked4 = this.intent.getBooleanExtra("checkBoxValue", false).toString()
        //val isChecked5 = this.intent.getBooleanExtra("checkBoxValue", false).toString()
        //val isChecked6 = this.intent.getBooleanExtra("checkBoxValue", false).toString()
        bet2.run {
            //val isChecked2 = this.intent.getBooleanExtra("checkBoxValue", false).toString()
            //val isChecked3 = this.intent.getBooleanExtra("checkBoxValue", false).toString()
            //val isChecked4 = this.intent.getBooleanExtra("checkBoxValue", false).toString()
            //val isChecked5 = this.intent.getBooleanExtra("checkBoxValue", false).toString()
            //val isChecked6 = this.intent.getBooleanExtra("checkBoxValue", false).toString()

            bet1.text.equals(isChecked)
        }


        backBtn.setOnClickListener {
            val back = Intent(this, MainActivity::class.java)
            startActivity(back)
        }

        //confirmBets.setOnClickListener {
        //            val confirm = Intent(this, MainActivity3::class.java)
        //            startActivity(confirm)
        //        }


    }
}
