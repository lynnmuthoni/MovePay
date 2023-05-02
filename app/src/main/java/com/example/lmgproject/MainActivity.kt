package com.example.lmgproject
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.sql.DriverManager
import java.sql.SQLException


class MainActivity : AppCompatActivity() {



    var userName:EditText?=null
    var userPass:EditText?=null
    var buttonLogin:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        userName=findViewById(R.id.edt_text)
        userPass=findViewById(R.id.edt_pass)
        buttonLogin=findViewById(R.id.mbtn_login)

        buttonLogin.setOnClickListener {
            val useremail=userName!!.text.toString()
            val userpass=userPass!!.text.toString()



            //Checking if user field is empty
            if ( useremail.isEmpty()&&userpass.isEmpty()) {

                Toast.makeText(this,"Please fill in all the fields", Toast.LENGTH_LONG).show()
            }


            else{
                val conn = DriverManager.getConnection(url)
                try {
                    val stmt = conn.createStatement()
                    val sql = "SELECT COUNT(*) FROM users WHERE username = '$username' AND password = '$password'"
                    val rs = stmt.executeQuery(sql)
                    if (rs.getInt(1) == 1) {
                        println("Login successful")
                        val intent= Intent(this,DashboardActivity::class.java)
                        startActivity(intent)
                        finish()


                    } else {
                        println("Invalid username or password")
                    }
                } catch (e: SQLException) {
                    println("Login failed: ${e.message}")
                } finally {
                    conn.close()
                }
            }

                }
            }

        }
    }
}