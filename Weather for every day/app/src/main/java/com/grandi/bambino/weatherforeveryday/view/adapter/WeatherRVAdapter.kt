package com.grandi.bambino.weatherforeveryday.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grandi.bambino.weatherforeveryday.model.entity.Weathers

//TODO Доделать адаптер
class WeatherRVAdapter(val data: List<Weathers>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(data: Weathers){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}