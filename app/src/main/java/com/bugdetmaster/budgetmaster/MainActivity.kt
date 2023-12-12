package com.bugdetmaster.budgetmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setze das Layout der Aktivität
        setContentView(R.layout.activity_main)

        // Finde das NavHostFragment in der Fragment-Hierarchie
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // Initialisiere den NavController mit dem NavHostFragment
        navController = navHostFragment.findNavController()

        // Verknüpfe die BottomNavigationView mit dem NavController
        findViewById<BottomNavigationView>(R.id.bottom_nav).setupWithNavController(navController)


    }


}