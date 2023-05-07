package com.example.final_project_practice

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView

class MainClassList : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_class_list)

        val swDegCert = findViewById<Switch>(R.id.swDegreeAndCert)
        val spnDegree = findViewById<Spinner>(R.id.listMajor)
        val spnCertificate = findViewById<Spinner>(R.id.listCert)
        val txtCertificate = findViewById<TextView>(R.id.certTxt)
        val txtDegree = findViewById<TextView>(R.id.majorTxt)
        val btnNext = findViewById<Button>(R.id.nxtBtn)

        val firstName = findViewById<EditText>(R.id.firstNameTxt)
        val lastName = findViewById<EditText>(R.id.lastNameTxt)
        val phone = findViewById<EditText>(R.id.phoneInput)

        val spMonth = findViewById<Spinner>(R.id.spnMonth)
        val txtDay = findViewById<EditText>(R.id.dayTxt)
        val txtYear = findViewById<EditText>(R.id.yearTxt)

        firstName.requestFocus()


        swDegCert.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                spnDegree.visibility = View.VISIBLE
                txtDegree.visibility = View.VISIBLE
                spnCertificate.visibility = View.GONE
                txtCertificate.visibility = View.GONE

            } else {
                spnDegree.visibility = View.GONE
                txtDegree.visibility = View.GONE
                spnCertificate.visibility = View.VISIBLE
                txtCertificate.visibility = View.VISIBLE
            }
        }

        btnNext.setOnClickListener {
            if (checkData()) {
                var doBirth = ""
                doBirth =
                    spMonth.selectedItem.toString() + "/" + txtDay.text.toString() + "/" + txtYear.text.toString()

                val nextScreen = Intent(this@MainClassList, ChooseClass::class.java)
                nextScreen.putExtra("FirstName", firstName.text.toString())
                nextScreen.putExtra("LastName", lastName.text.toString())
                nextScreen.putExtra("Phone", phone.text.toString())
                nextScreen.putExtra("BirthDate", doBirth)

                if (spnDegree.visibility == View.VISIBLE) {
                    nextScreen.putExtra("isDegreeCert", "Degree")
                    nextScreen.putExtra("degreeCert", spnDegree.selectedItem.toString())
                } else {
                    nextScreen.putExtra("isDegreeCert", "Certificate")
                    nextScreen.putExtra("degreeCert", spnCertificate.selectedItem.toString())
                }

                //Start Activity
                startActivity(nextScreen)
            }
        }
    }

            private fun checkData(): Boolean{
                val firstName = findViewById<EditText>(R.id.firstNameTxt)
                val lastName = findViewById<EditText>(R.id.lastNameTxt)
                val phone = findViewById<EditText>(R.id.phoneInput)
                val txtDay = findViewById<EditText>(R.id.dayTxt)
                val txtYear = findViewById<EditText>(R.id.yearTxt)

                if (firstName.text.toString().isEmpty()){
                    //error
                    firstName.error = "Invalid First Name"
                    firstName.requestFocus()
                    return false
                }
                if (lastName.text.toString().isEmpty()){
                    //error
                    lastName.error = "Invalid Last Name"
                    lastName.requestFocus()
                    return false
                }
                if (phone.text.toString().isEmpty()){
                    //error
                    phone.error = "Invalid Phone Number"
                    phone.requestFocus()
                    return false
                }
                if (txtDay.text.toString().isEmpty()){
                    //error
                    txtDay.error = "Invalid Date Selection"
                    txtDay.requestFocus()
                    return false
                }
                if (txtYear.text.toString().isEmpty()){
                    //error
                    txtYear.error = "Invalid Year Selection"
                    txtYear.requestFocus()
                    return false
                }


                return true
            }
}




