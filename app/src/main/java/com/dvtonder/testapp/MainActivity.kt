package com.dvtonder.testapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            startDetailsActivity()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_toggle_dark -> {
                isDarkMode = !isDarkMode
                return true
            }

            R.id.action_toggle_new -> {
                isNewTask = !isNewTask
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun startDetailsActivity() {
        val detailsIntent = Intent(this, TaskDetailsActivity::class.java)
        detailsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(detailsIntent)
    }

    companion object {
        var isDarkMode = false
        var isNewTask = false
    }
}
