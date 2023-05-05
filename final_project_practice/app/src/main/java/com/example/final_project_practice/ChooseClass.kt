package com.example.final_project_practice

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class ChooseClass : AppCompatActivity() {

    private var firstName: String? = ""
    private var lastName: String? = ""
    private var phone: String? = ""
    private var birthDate: String? = ""
    private var isDegreeCert: String? = ""
    private var degreeCertification: String? = ""

    private var ctv1: CheckedTextView? = null
    private var ctv2: CheckedTextView? = null
    private var ctv3: CheckedTextView? = null
    private var ctv4: CheckedTextView? = null

    private var rb1: RadioButton? = null
    private var rb2: RadioButton? = null
    private var rb3: RadioButton? = null
    private var rb4: RadioButton? = null
    private var rb5: RadioButton? = null
    private var rb6: RadioButton? = null
    private var rb7: RadioButton? = null
    private var rb8: RadioButton? = null

    private var rg1: RadioGroup? = null
    private var rg2: RadioGroup? = null
    private var rg3: RadioGroup? = null
    private var rg4: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_class)

        ctv1 = findViewById<CheckedTextView>(R.id.ctv1)
        ctv2 = findViewById<CheckedTextView>(R.id.ctv2)
        ctv3 = findViewById<CheckedTextView>(R.id.ctv3)
        ctv4 = findViewById<CheckedTextView>(R.id.ctv4)

        rb1 = findViewById<RadioButton>(R.id.rb1)
        rb2 = findViewById<RadioButton>(R.id.rb2)
        rb3 = findViewById<RadioButton>(R.id.rb3)
        rb4 = findViewById<RadioButton>(R.id.rb4)
        rb5 = findViewById<RadioButton>(R.id.rb5)
        rb6 = findViewById<RadioButton>(R.id.rb6)
        rb7 = findViewById<RadioButton>(R.id.rb7)
        rb8 = findViewById<RadioButton>(R.id.rb8)

        val btnNext = findViewById<Button>(R.id.btnNext)

        val extras = intent.extras
        if (extras != null){
            firstName = extras.getString("firstName")
            lastName = extras.getString("lastName")
            phone = extras.getString("phone")
            birthDate = extras.getString("birthDate")
            isDegreeCert = extras.getString("isDegreeCert")
            degreeCertification = extras.getString("degreeCert")
        }

        btnNext.setOnClickListener{
            var radioBtn: RadioButton
            var ctv1Text = ""
            var ctv2Text = ""
            var ctv3Text = ""
            var ctv4Text = ""
            var radio1Txt = ""
            var radio2Txt = ""
            var radio3Txt = ""
            var radio4Txt = ""

            rg1 = findViewById(R.id.RG1)
            rg2 = findViewById(R.id.RG2)
            rg3 = findViewById(R.id.RG3)
            rg4 = findViewById(R.id.RG4)

            var selectTime1 = 0
            var selectTime2 = 0
            var selectTime3 = 0
            var selectTime4 = 0

            if (ctv1!!.isChecked){
                ctv1Text = ctv1!!.text.toString()
                selectTime1 = rg1!!.checkedRadioButtonId
                radioBtn = findViewById<RadioButton>(selectTime1) // R.id.<whatever>
                radio1Txt = radioBtn.text.toString()
            }
            if (ctv2!!.isChecked){
                ctv2Text = ctv2!!.text.toString()
                selectTime2 = rg2!!.checkedRadioButtonId
                radioBtn = findViewById<RadioButton>(selectTime2)
                radio2Txt = radioBtn.text.toString()
            }
            if (ctv3!!.isChecked){
                ctv3Text = ctv3!!.text.toString()
                selectTime3 = rg3!!.checkedRadioButtonId
                radioBtn = findViewById<RadioButton>(selectTime3)
                radio3Txt = radioBtn.text.toString()
            }
            if (ctv4!!.isChecked){
                ctv4Text = ctv4!!.text.toString()
                selectTime4 = rg4!!.checkedRadioButtonId
                radioBtn = findViewById<RadioButton>(selectTime4)
                radio4Txt = radioBtn.text.toString()
            }

            if (radioCheck(selectTime1, selectTime2, selectTime3, selectTime4)){

                //intent to next screen
                val nextScreen2 = Intent(this@ChooseClass, Summary::class.java).apply{
                    putExtra("firstName", firstName)
                    putExtra("lastName", lastName)
                    putExtra("phone", phone)
                    putExtra("birthDate", birthDate)
                    putExtra("isDegreeCert", isDegreeCert)
                    putExtra("Class1", ctv1Text)
                    putExtra("Selected1", selectTime1)
                    putExtra("Class2", ctv2Text)
                    putExtra("Selected2", selectTime2)
                    putExtra("Class3", ctv3Text)
                    putExtra("Selected3", selectTime3)
                    putExtra("Class4", ctv4Text)
                    putExtra("Selected4", selectTime4)
                    putExtra("degreeCert", degreeCertification)
                }
                //Start the Activity
                startActivity(nextScreen2)

            }else{
                Toast.makeText(applicationContext, "Time slot Conflict!", Toast.LENGTH_LONG).show()
            }

        }

        rb1!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb2!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb3!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb4!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb5!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb6!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb7!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        rb8!!.setOnCheckedChangeListener { buttonView, isChecked ->
            rb1!!.error = null
            rb2!!.error = null
            rb3!!.error = null
            rb4!!.error = null
            rb5!!.error = null
            rb6!!.error = null
            rb7!!.error = null
            rb8!!.error = null
        }
        ctv1!!.setOnClickListener{
            if (ctv1!!.isChecked){
                enableDisable(ctv1, rb1, rb2, Color.WHITE,false)

            }else{
                enableDisable(ctv1, rb1, rb2, Color.GRAY, true)
                rb1!!.isChecked = true
            }
        }
        ctv2!!.setOnClickListener{
            if (ctv2!!.isChecked){
                enableDisable(ctv2, rb3, rb4, Color.WHITE,false)
            }else{
                enableDisable(ctv2, rb3, rb4, Color.GRAY, true)
                rb3!!.isChecked = true
            }
        }
        ctv3!!.setOnClickListener{
            if (ctv3!!.isChecked){
                enableDisable(ctv3, rb5, rb6, Color.WHITE,false)
            }else{
                enableDisable(ctv3, rb5, rb6, Color.GRAY, true)
                rb5!!.isChecked = true
            }
        }
        ctv4!!.setOnClickListener{
            if (ctv4!!.isChecked){
                enableDisable(ctv4, rb7, rb8, Color.WHITE,false)
            }else{
                enableDisable(ctv4, rb7, rb8, Color.GRAY, true)
                rb7!!.isChecked = true
            }
        }
    }

    fun enableDisable(ctv: CheckedTextView?, rb1: RadioButton?, rb2: RadioButton?, backgroundColor: Int?, state: Boolean?){
        ctv!!.isChecked = state!!
        ctv.setBackgroundColor(backgroundColor!!)
        rb1!!.isEnabled = state
        rb2!!.isEnabled = state
        rb1.isChecked = state
        rb2.isChecked = state
        if (!state){
            rb1.isChecked = state
            rb2.isChecked = state
        }
    }

    fun radioCheck(selectedTime1: Int, selectedTime2: Int, selectedTime3: Int, selectedTime4: Int): Boolean{

        if (selectedTime1 == R.id.rb2 && selectedTime4 == R.id.rb7){
            rb2!!.error = "Time slot Conflict"
            rb7!!.error = "Time slot Conflict"
            return false
        }
        if (selectedTime1 == R.id.rb1 && selectedTime2 == R.id.rb3){
            rb1!!.error = "Time slot Conflict"
            rb3!!.error = "Time slot Conflict"
            return false
        }
        if (selectedTime3 == R.id.rb5 && selectedTime4 == R.id.rb8){
            rb5!!.error = "Time slot Conflict"
            rb8!!.error = "Time slot Conflict"
            return false
        }

        return true
    }
}