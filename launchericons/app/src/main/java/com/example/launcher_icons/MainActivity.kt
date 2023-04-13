package com.example.launcher_icons

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.mipmap.ic_launcher)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val convertNum = findViewById<EditText>(R.id.convertNumber)
        val rbInToCm = findViewById<RadioButton>(R.id.radioButtonIN2CM)
        val rbCmToIn = findViewById<RadioButton>(R.id.radioButtonCM2IN)
        val convertIt = findViewById<Button>(R.id.button)
        val txtResult = findViewById<TextView>(R.id.resultID)

        convertIt.setOnClickListener {
            val tenth = DecimalFormat("#.#")
            val dblMeasure = convertNum.text.toString().toDouble()
            val conversionRate = 2.54
            var convertMeasureNum: Double?

            if (rbInToCm.isActivated) {
                if (dblMeasure <= 72) {
                    convertMeasureNum = dblMeasure * conversionRate
                    txtResult.text = tenth.format(convertMeasureNum) + "cm"
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Inches must be less than 72in",
                        Toast.LENGTH_LONG
                    ).show()
                }

            }

            if (rbCmToIn.isActivated) {
                if (dblMeasure <= 185) {
                    convertMeasureNum = dblMeasure * conversionRate
                    txtResult.text = tenth.format(convertMeasureNum) + "in"
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Centimeters must be less than 185cm",
                        Toast.LENGTH_LONG
                    ).show()
                }

            }


        }
    }
}