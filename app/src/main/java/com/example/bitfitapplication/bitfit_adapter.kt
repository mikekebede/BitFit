package com.example.bitfitapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class bitfit_adapter(var foodCalorie :List<bitfit>):RecyclerView.Adapter<bitfit_adapter.bitfitViewHolder>()  {
    inner class bitfitViewHolder(bitfitView:View):RecyclerView.ViewHolder(bitfitView){
        val foodText=bitfitView.findViewById<TextView>(R.id.food_view)
        val calorieText=bitfitView.findViewById<TextView>(R.id.calorie_view)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bitfitViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.food_calorie_input_view, parent, false)
        return bitfitViewHolder(view)
    }


    override fun getItemCount(): Int {
        return foodCalorie.size
    }

    override fun onBindViewHolder(holder: bitfitViewHolder, position: Int) {
        holder.apply {

            foodText.text=foodCalorie[position].food
            calorieText.text=foodCalorie[position].calories


        }
    }



}