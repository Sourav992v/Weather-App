package com.sourav.weatherapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.sourav.weatherapp.R
import com.sourav.weatherapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

//Created on 22 April 2021 by Sourav
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            val navController = findNavController(R.id.fragment)
            bottomNavigationView.setupWithNavController(navController)

            val appBarConfig = AppBarConfiguration(setOf(R.id.hourlyFragment, R.id.dailyFragment))
            setupActionBarWithNavController(navController, appBarConfig)

    }
}