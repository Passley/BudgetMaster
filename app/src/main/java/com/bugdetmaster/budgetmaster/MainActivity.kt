package com.bugdetmaster.budgetmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/**
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        val navController = findViewById<FrameLayout>(R.id.nav_host_fragment).findNavController()
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.uebersichtFragment, R.id.ausgabenFragment, R.id.sparplanFragment, R.id.settingsOneFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)


        bottomNavigationView.setupWithNavController(navController)


*/
    }


}