package com.learn.bookhub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.design.circularreveal.coordinatorlayout.CircularRevealCoordinatorLayout
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.widget.FrameLayout
import android.widget.Toolbar

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frame)
        navigationView = findViewById(R.id.navigationView)
        //setUpToolbar()

    }
    //fun setUpToolbar(){
        //setSupportActionBar(toolbar)
        //supportActionBar?.title = "Toolbar Title"
    //}
}