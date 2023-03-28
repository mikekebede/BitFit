package com.example.bitfitapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bit_fit_List= mutableListOf<bitfit>()
        val rvadapter=bitfit_adapter(bit_fit_List)
        val rvBitfit = findViewById<View>(R.id.rv_bitfit) as RecyclerView
        rvBitfit.isNestedScrollingEnabled = false
        lifecycleScope.launch{
            (application as bitfitApplication).db.bitfitDao().getAll().collect {databaseList->
                databaseList.map {  Bentity->
                    bitfit(Bentity.food, Bentity.calories)

                }.also{ maplist ->

                    bit_fit_List.clear()
                   bit_fit_List.addAll(maplist)
                    rvadapter.notifyDataSetChanged()
                }
            }
        }


        rvBitfit.adapter=rvadapter
        rvBitfit.layoutManager=LinearLayoutManager(this).also{
            val dividerItemDecoration=DividerItemDecoration(this, it.orientation)
            rvBitfit.addItemDecoration(dividerItemDecoration)
        }

        val addButton=findViewById<Button>(R.id.add_food)

        addButton.setOnClickListener{
            val intent= Intent(this , detailActivity::class.java)
            startActivity(intent)

            Log.i("Yesigat" , "it was clicked")
        }


    }
}