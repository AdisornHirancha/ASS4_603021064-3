package com.example.ass4_603021064_3

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        btn_pickDate.setOnClickListener {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener {view, mYear, mMonth, mDay ->
                   text_date.setText("" + mDay + "/" + mMonth + "/" +mYear)
                },
                year,month,day
            )
            dpd.show()
        }
    }

    fun radio_button_click(view: View){
        val radio: RadioButton = findViewById(gender.checkedRadioButtonId)
        Toast.makeText(applicationContext, "On click : ${radio.text}",Toast.LENGTH_SHORT)
            .show()
    }

    fun showDetail(view: View){
        val radio: RadioButton = findViewById(gender.checkedRadioButtonId)
        text_show.text =
            "Username: ${edit_username.text}\nPassword: ${edit_password.text}\nGender: ${radio.text}\nEmail: ${edit_email.text} \nTime: ${text_date.text}"

    }
    fun reset(v: View){
        edit_username.text.clear()
        edit_password.text.clear()
        gender.clearCheck()
        edit_email.text.clear()
        text_date.text = "dd / mm / yyyy"
        text_show.text = "Show detail"
    }
}
