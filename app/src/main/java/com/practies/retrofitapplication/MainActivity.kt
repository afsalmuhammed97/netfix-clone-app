package com.practies.retrofitapplication

 import android.os.Bundle
 import androidx.appcompat.app.AppCompatActivity
 import androidx.navigation.findNavController
 import androidx.navigation.ui.setupWithNavController
 import com.google.android.material.bottomnavigation.BottomNavigationMenuView
 import com.google.android.material.bottomnavigation.BottomNavigationView
 import dagger.hilt.android.AndroidEntryPoint


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//
//           val navController=findNavController(R.id.fragmentContainerView3)
//
//         bottomNavigationView.setupWithNavController(navController)

    }

    override fun onStart() {
        super.onStart()

        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        val navController=findNavController(R.id.fragmentContainerView3)

        bottomNavigationView.setupWithNavController(navController)

    }

}