package com.example.final_project

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class place_bets : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_bets)


        val boat1 = findViewById<CheckBox>(R.id.ChkBoat1)
        val boat2 = findViewById<CheckBox>(R.id.ChkBoat2)
        val boat3 = findViewById<CheckBox>(R.id.ChkBoat3)
        val boat4 = findViewById<CheckBox>(R.id.ChkBoat4)
        val boat5 = findViewById<CheckBox>(R.id.ChkBoat5)
        val boat6 = findViewById<CheckBox>(R.id.ChkBoat6)
        val nextBtn = findViewById<Button>(R.id.NextBtn)
        var checked = 0

        val boat1Check = boat1.isChecked
        val boat2Check = boat2.isChecked
        val boat3Check = boat3.isChecked
        val boat4Check = boat4.isChecked
        val boat5Check = boat5.isChecked
        val boat6Check = boat6.isChecked

        val isChecked1: Boolean = boat1Check
        val isChecked2: Boolean = boat2Check
        val isChecked3: Boolean = boat3Check
        val isChecked4: Boolean = boat4Check
        val isChecked5: Boolean = boat5Check
        val isChecked6: Boolean = boat6Check


        if (boat1Check) {
            checked++
        }
        if (boat2Check) {
            checked++
        }
        if (boat3Check){
            checked++
        }
        if (boat4Check){
            checked++
        }
        if (boat5Check){
            checked++
        }
        if (boat6Check){
            checked++
        }
        val boatA = Intent(this, confirm_bets::class.java)
        boatA.putExtra("checkBoxValue", isChecked1)
        startActivity(boatA)
        val boatB = Intent(this, confirm_bets::class.java)
        boatB.putExtra("checkBoxValue", isChecked2)
        startActivity(boatB)
        val boatC = Intent(this, confirm_bets::class.java)
        boatC.putExtra("checkBoxValue", isChecked3)
        startActivity(boatC)
        val boatD = Intent(this, confirm_bets::class.java)
        boatD.putExtra("checkBoxValue", isChecked4)
        startActivity(boatD)
        val boatE = Intent(this, confirm_bets::class.java)
        boatE.putExtra("checkBoxValue", isChecked5)
        startActivity(boatE)
        val boatF = Intent(this, confirm_bets::class.java)
        boatF.putExtra("checkBoxValue", isChecked6)
        startActivity(boatF)

        nextBtn.setOnClickListener {
            when (check(checked != 2)) {
                check(checked != 2) -> {
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.errorID),
                        Toast.LENGTH_LONG
                    ).show()
                    nextBtn.requestFocus()
                }
                else ->
                    nextBtn.setOnClickListener {
                        val intent = Intent(this, confirm_bets::class.java)
                        startActivity(intent)
                    }

            }
        }
    }
}