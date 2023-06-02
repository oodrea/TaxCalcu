/**
 * Name:    Lapuz, Mari Salvador
 *          Martin, Elaine Riz C.
 *          Samson, Wesly F.
 *          Tabadero, Audrea Arjaemi T.
 *
 * Language: Kotlin
 *
 * Paradigm: OOP and Functional
 * */


package com.example.taxcalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.taxcalculator.R.id.*
import com.example.taxcalculator.TaxComputation


class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val salary = findViewById<EditText>(MonthlySal)

        val incomeTax = findViewById<EditText>(IncomeTax)

        val netPayTax = findViewById<EditText>(NetPayTax)

        val sss = findViewById<EditText>(SSS)

        val philHealth = findViewById<EditText>(PhilHealth)

        val pagIBIG = findViewById<EditText>(PagIBIG)

        val totalCon = findViewById<EditText>(TotalCon)

        val totalDeduc = findViewById<EditText>(TotalDeduc)

        val netPayDeduc = findViewById<EditText>(NetPayDeduc)

        val b1 = findViewById<Button>(btnOk)

        val b2 = findViewById<Button>(btnCancel)

        b2.setOnClickListener {
            salary.setText("")
            sss.setText("")
            philHealth.setText("")
            pagIBIG.setText("")
            totalCon.setText("")
            totalDeduc.setText("")
            netPayDeduc.setText("")
            incomeTax.setText("")
            netPayTax.setText("")
        }

        b1.setOnClickListener {

            val sal1 = salary.text.toString().toDouble()
            var tax = TaxComputation(sal1)

            var temp = String.format("%.2f", tax.getSSS())
            sss.setText(temp)

            temp = String.format("%.2f", tax.getPhilhealth())
            philHealth.setText(temp)

            temp = String.format("%.2f", tax.getPagIbig())
            pagIBIG.setText(temp)

            temp = String.format("%.2f", tax.getTotalContri())
            totalCon.setText(temp)

            temp = String.format("%.2f", tax.getTotalDeduc())
            totalDeduc.setText(temp)

            temp = String.format("%.2f", tax.getNetPayDeduc())
            netPayDeduc.setText(temp)

            temp = String.format("%.2f", tax.getIncomeTax())
            incomeTax.setText(temp)

            temp = String.format("%.2f", tax.getNetPayTax())
            netPayTax.setText(temp)


        }

    }
}