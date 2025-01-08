package com.example.medplus.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coordinate_layout.R
import com.example.medplus.interfaces.BestSellerInterface

class BestsellerAdapter(
    context: Context,
var list:ArrayList<String>,
var bestseller_Interface: BestSellerInterface
)
    : RecyclerView.Adapter<BestsellerAdapter.ViewHolder>()
{
    class ViewHolder(var view: View):RecyclerView.ViewHolder(view) {
        val texV =view.findViewById<TextView>(R.id.spdyImg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.bestseller_rv,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.texV.text=list[position]
    }
}