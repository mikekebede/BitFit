package com.example.bitfitapplication
import android.content.Intent

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.bitfitapplication.databinding.ActivityDetailBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class detailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val record_button=findViewById<Button>(R.id.record_button)
        record_button.setOnClickListener{
            val food=findViewById<EditText>(R.id.food_add).text.toString()
            val calorie=findViewById<EditText>(R.id.calorie_add).text.toString()
            lifecycleScope.launch(Dispatchers.IO){
                (application as bitfitApplication).db.bitfitDao().insert(
                    BitfitEntity(food,calorie)
                )

            }
            val intent_detail=Intent(this@detailActivity,MainActivity::class.java)
            startActivity(intent_detail)
        }


    }
}