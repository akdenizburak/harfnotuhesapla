package com.burakakdeniz.harfnotuhesapla

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Splashscreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val background =object : Thread() {
            override fun run() {
                try {
                    sleep(2000)

                    val intent = Intent(baseContext,MainActivity::class.java)
                    startActivity(intent)
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}
