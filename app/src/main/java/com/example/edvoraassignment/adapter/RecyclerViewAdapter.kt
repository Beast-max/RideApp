package com.example.edvoraassignment.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.edvoraassignment.Extensions.load
import com.example.edvoraassignment.Model.RideResponseItem
import com.example.edvoraassignment.R
import org.w3c.dom.Text

class RecyclerViewAdapter:ListAdapter<RideResponseItem,RecyclerViewAdapter.ViewHolder>(object :DiffUtil.ItemCallback<RideResponseItem>(){
    override fun areItemsTheSame(oldItem: RideResponseItem, newItem: RideResponseItem): Boolean {
        return oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: RideResponseItem, newItem: RideResponseItem): Boolean {
        return oldItem==newItem
    }

}) {
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val mapimage = itemView.findViewById<ImageView>(R.id.mapimage)
        val city = itemView.findViewById<Button>(R.id.city)
        val state  = itemView.findViewById<Button>(R.id.state)
        val rideID = itemView.findViewById<TextView>(R.id.rideid)
        val origin = itemView.findViewById<TextView>(R.id.orign)
        val path = itemView.findViewById<TextView>(R.id.path)
        val date = itemView.findViewById<TextView>(R.id.date)
        val distance = itemView.findViewById<TextView>(R.id.distance)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_layout,parent,false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val po  = getItem(position)
        val date = po.date
        holder.date.text = "Ride Id : $date"
        holder.city.text = po.city
        holder.state.text = po.state
        val origin = po.originStationCode
        holder.origin.text = "Origin station : $origin"
        val path = po.stationPath
        holder.path.text = "Station Path : $path"
        val distance = po.destinationStationCode
        holder.distance.text = "Distance : $distance"
        val rideid = po.id
        holder.rideID.text = "Date : $rideid"
        holder.mapimage.load(po.mapUrl)
    }
}