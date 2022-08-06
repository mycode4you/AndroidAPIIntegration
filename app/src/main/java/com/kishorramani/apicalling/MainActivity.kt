package com.kishorramani.apicalling

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.kishorramani.apicalling.api.RetrofitInstance
import com.kishorramani.apicalling.databinding.ActivityMainBinding
import com.kishorramani.apicalling.utils.CommonConstant
import retrofit2.HttpException
import java.io.IOException
import kotlin.math.floor

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        clickMethod()
    }

    private fun initViews() {
        val number = floor(Math.random() * 9000000000L).toLong() + 1000000000L
        binding.edtGeniusPractitioner.text = Editable.Factory.getInstance().newEditable(number.toString())
    }

    private fun clickMethod() {
        binding.btnSignUp.setOnClickListener {
            val userName = binding.edtFullName.text.toString()
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()
            val confirmPassword = binding.edtConfirmPassword.text.toString()
            val uuid = binding.edtGeniusPractitioner.text.toString()

            if (validateSignUpDate(userName, email, password, confirmPassword)) {
                Toast.makeText(this@MainActivity, "Validation Success", Toast.LENGTH_LONG).show()
                callSignUpService(userName, email, password, uuid)
            }
        }
    }

    private fun validateSignUpDate(
        userName: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (userName.isEmpty()) {
            Toast.makeText(this@MainActivity, "Please Enter Valid User Name", Toast.LENGTH_LONG).show()
            return false
        } else if (email.isEmpty()) {
            Toast.makeText(this@MainActivity, "Please Enter Valid Email", Toast.LENGTH_LONG).show()
            return false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this@MainActivity, "Please Enter Valid Email", Toast.LENGTH_LONG).show()
            return false
        } else if (password.isEmpty()) {
            Toast.makeText(this@MainActivity, "Please Enter Valid password", Toast.LENGTH_LONG).show()
            return false
        } else if (confirmPassword.isEmpty()) {
            Toast.makeText(this@MainActivity, "Please Enter Valid confirmPassword", Toast.LENGTH_LONG).show()
            return false
        } else if (password != confirmPassword) {
            Toast.makeText(this@MainActivity, "Password and Confirm password should be match", Toast.LENGTH_LONG).show()
            return false
        } else if (!CommonConstant.isPasswordMatch(password)) {
            Toast.makeText(this@MainActivity, "Password should be (at least one capital,one special character and number also must be 8 char long)", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

    private fun callSignUpService(userName: String, email: String, password: String, uuid: String) {
        lifecycleScope.launchWhenCreated {
            val response = try {
                RetrofitInstance.api.callSignUpService(
                    userName,
                    email,
                    password,
                    uuid,
                    CommonConstant.referral
                )
            } catch (e: IOException) {
                e.printStackTrace()
                Log.e(TAG, "IOException, You might not have internet connection")
                return@launchWhenCreated
            } catch (e: HttpException) {
                e.printStackTrace()
                Log.e(TAG, "HttpException, unexpected response")
                return@launchWhenCreated
            }

            if (response.isSuccessful && response.body() != null) {
                Toast.makeText(this@MainActivity, "SignUp Success", Toast.LENGTH_LONG).show()
            } else {
                Log.e(TAG, "Response not successful")
            }
        }
    }
}