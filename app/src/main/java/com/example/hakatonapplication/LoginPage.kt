package com.example.hakatonapplication

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.yandex.mapkit.MapKitFactory

class LoginPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //MapKitFactory.setApiKey("2a07e21a-3802-4638-8eb2-0014a602c48c")
        //MapKitFactory.initialize(this)

        setContentView(R.layout.login_page)

        findViewById<TextView>(R.id.forget_password).clickWithDebounce {
            if (findViewById<EditText>(R.id.enter_email_auth_enter_with_email).getText().toString() == "user" &&
                findViewById<EditText>(R.id.enter_password_auth_enter_with_email).getText().toString() == "0000")
            {
                startActivity(Intent(this@LoginPage, MainActivity::class.java))
                finish()
            }
        }


    }


    fun View.clickWithDebounce(debounceTime: Long = 600L, action: () -> Unit) {
        this.setOnClickListener(object : View.OnClickListener {
            private var lastClickTime: Long = 0

            override fun onClick(v: View) {
                if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return
                else action()

                lastClickTime = SystemClock.elapsedRealtime()
            }
        })
    }
}