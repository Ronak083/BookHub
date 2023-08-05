package com.learn.bookhub.adapter
import android.content.Context
import android.view.LayoutInflater
import com.learn.bookhub.R
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.ArrayList
import androidx.recyclerview.widget.RecyclerView

class DashboardRecyclerAdapter(val context: Context, val itemList: ArrayList<String>) : RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent,false)
        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val text = itemList[position]
        holder.textView.text = text
    }

    class DashboardViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.txtRecyclerRowItem)
    }
}