package com.example.ageinmin

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnDatePicker).setOnClickListener{view->
           clickDatePicker(view)

        }
    }
    fun clickDatePicker(view: View){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, syear, smonth, sday ->
            Toast.makeText(this,"The chosen date is $sday ${smonth +1} $syear",Toast.LENGTH_SHORT).show()
            var selecteddate ="$sday/${smonth +1}/$syear"
           findViewById<TextView>(R.id.tvSelectedDate).setText(selecteddate)
            val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val theDate: Date = sdf.parse(selecteddate)
            val DateInMinutes = theDate!!.time/60000

            val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMinutes = currentDate!!.time/60000
            val differenceInMinutes = currentDateInMinutes-DateInMinutes


            val differenceInDays = differenceInMinutes/1440
            val diff = differenceInMinutes%1440
            val differenceInHrs = diff/60

            findViewById<TextView>(R.id.tvSelectedDateInMin).setText(differenceInMinutes.toString())
            findViewById<TextView>(R.id.tvSelectedDateInDays).setText("${differenceInDays.toString()}d ${diff.toString()}h")
        },year, month, day)
        dpd.datePicker.setMaxDate(Date().time-86400000)
        dpd.show()
    }
}
