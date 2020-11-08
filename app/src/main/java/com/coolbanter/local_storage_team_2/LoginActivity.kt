 package com.coolbanter.local_storage_team_2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.coolbanter.local_storage_team_2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    lateinit var loginTest: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        retrievedata()

        binding = ActivityLoginBinding.inflate(layoutInflater)

        loginTest = binding.testFieldEditTest
        password = binding.passwordEdit

        binding.loginButton.setOnClickListener {

            val email:String = binding.testFieldEditTest.toString()
            val password:String = binding.passwordEdit.toString()

            if (email.trim().length == 0 || password.trim().length == 0) {
                Toast.makeText(this, "email or password is empty", Toast.LENGTH_SHORT).show()
            }

            else if (email.equals("abc") and password.equals("123")) {

                val mypref = getSharedPreferences("mypref", MODE_PRIVATE).edit()
                mypref.putString(email, "mypref")
                mypref.apply()

                val intent = Intent(this, LogutActivity::class.java)
                intent.putExtra("mypref", email)
                LogutActivity(intent)
            }
            else{
                Toast.makeText(this, "Username or password is incorrect", Toast.LENGTH_SHORT).show()
            }

        }
    }

    //To retrieve data with shared preference
            private fun retrievedata() {
        val mypref = getSharedPreferences("mypref", Context.MODE_PRIVATE)

        val name = mypref.getString("name", "")
        val password = mypref.getString("passord", "")

        binding.testFieldEditTest.setText(name)
        binding.passwordEdit.setText(password)
    }
}

