package com.example.final_wits_and_wagers

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.CheckedTextView
import android.widget.MultiAutoCompleteTextView
import android.widget.TextView

class confirm_bets : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_bets)

        val confirmBets = findViewById<Button>(R.id.confirmBtn)
        val backBtn = findViewById<Button>(R.id.BckBtn)
        val bets = findViewById<TextView>(R.id.results)

        val extras = intent.extras
        if (extras != null){
            val boat1 = extras.getString("boat1")
            val boat2 = extras.getString("boat2")
            val boat3 = extras.getString("boat3")
            val boat4 = extras.getString("boat4")
            val boat5 = extras.getString("boat5")
            val boat6 = extras.getString("boat6")

            val txtBoat1 = findViewById<CheckBox>(R.id.ChkBoat1)
            val txtBoat2 = findViewById<CheckBox>(R.id.ChkBoat2)
            val txtBoat3 = findViewById<CheckBox>(R.id.ChkBoat3)
            val txtBoat4 = findViewById<CheckBox>(R.id.ChkBoat4)
            val txtBoat5 = findViewById<CheckBox>(R.id.ChkBoat5)
            val txtBoat6 = findViewById<CheckBox>(R.id.ChkBoat6)

            txtBoat1.text = "$boat1"
            txtBoat2.text = "$boat2"
            txtBoat3.text = "$boat3"
            txtBoat4.text = "$boat4"
            txtBoat5.text = "$boat5"
            txtBoat6.text = "$boat6"

            val txtBets = java.lang.StringBuilder(250)
            if (boat1 != ""){
                txtBets.append(txtBoat1)
            }
            if (boat2 != ""){
                txtBets.append(txtBoat2)
            }
            if (boat3 != ""){
                txtBets.append(txtBoat3)
            }
            if (boat4 != ""){
                txtBets.append(txtBoat4)
            }
            if (boat5 != ""){
                txtBets.append(txtBoat5)
            }
            if (boat6 != ""){
                txtBets.append(txtBoat6)
            }
        bets.text = "$txtBets"

        }

        backBtn.setOnClickListener {
            val back = Intent(this@confirm_bets, MainActivity::class.java)
            startActivity(back)
        }

        confirmBets.setOnClickListener {
            val confirm = Intent(this@confirm_bets, results::class.java)
            startActivity(confirm)
        }


    }
}
