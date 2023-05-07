package com.example.final_project_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class Summary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val extras = intent.extras
        if (extras != null){
            val firstName = extras.getString("FirstName")
            val lastName = extras.getString("LastName")
            val phone = extras.getString("Phone")
            val birthDate = extras.getString("BirthDate")
            val isDegreeCert = extras.getString("isDegreeCert")
            val degreeCertification = extras.getString("degreeCert")
            val class1 = extras.getString("Class1")
            val selected1 = extras.getString("Selected1")
            val class2 = extras.getString("Class2")
            val selected2 = extras.getString("Selected2")
            val class3 = extras.getString("Class3")
            val selected3 = extras.getString("Selected3")
            val class4 = extras.getString("Class4")
            val selected4 = extras.getString("Selected4")

            val txtStudent = findViewById<TextView>(R.id.textStudent)
            val txtPhone = findViewById<TextView>(R.id.textPhone)
            val txtBirthdate = findViewById<TextView>(R.id.textBirthdate)
            val txtDegreePlan = findViewById<TextView>(R.id.textDegree)
            val txtMajor = findViewById<TextView>(R.id.textMajor)
            val txtClassSchedule = findViewById<TextView>(R.id.textClassSchedule)

            txtStudent.text = "$firstName $lastName"
            txtPhone.text = "$phone"
            txtBirthdate.text = "$birthDate"
            txtDegreePlan.text = "$isDegreeCert"
            txtMajor.text = "$degreeCertification"

            val classSchedule = java.lang.StringBuilder(300)
            if (class1 != ""){
                classSchedule.append(class1 + "\n" + selected1 + "\n\n")
            }
            if (class2 != ""){
                classSchedule.append(class2 + "\n" + selected2 + "\n\n")
            }
            if (class3 != ""){
                classSchedule.append(class3 + "\n" + selected3 + "\n\n")
            }
            if (class4 != ""){
                classSchedule.append(class4 + "\n" + selected4 + "\n\n")
            }
            txtClassSchedule.text = "$classSchedule"
        }

    }
}