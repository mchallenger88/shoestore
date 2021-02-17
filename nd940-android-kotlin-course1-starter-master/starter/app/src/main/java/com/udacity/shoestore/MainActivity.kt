package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        drawerLayout = binding.drawerLayout
        val navController = this.findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
//        NavigationUI.setupWithNavController(binding.navView, navController)

        Timber.plant(Timber.DebugTree())
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)

        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}
