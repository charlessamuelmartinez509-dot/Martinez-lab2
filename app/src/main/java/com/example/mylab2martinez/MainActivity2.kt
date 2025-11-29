package com.example.mylab2martinez

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val Questionfield = findViewById<EditText>(R.id.question)
        val Reponsefield = findViewById<EditText>(R.id.reponse)
        val save_icon = findViewById<ImageView>(R.id.savebutton)
        val cancel_icon = findViewById<ImageView>(R.id.cancelbutton)

        cancel_icon.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }

        save_icon.setOnClickListener {
            val userquestion = Questionfield.text.toString()
            val userreponse = Reponsefield.text.toString()

            val data = Intent() // create a new Intent, this is where we will put our data

            data.putExtra(
                "Question_key",
                userquestion
            ) // puts one string into the Intent, with the key as 'string1'

            data.putExtra(
                "Reponse_key",
                userreponse
            ) // puts another string into the Intent, with the key as 'string2

            setResult(RESULT_OK, data) // set result code and bundle data for response

            finish()

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}