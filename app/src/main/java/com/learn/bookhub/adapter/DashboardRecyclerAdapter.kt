package com.learn.bookhub.adapter
import android.content.Context
import android.view.LayoutInflater
import com.learn.bookhub.R
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import java.util.ArrayList
import androidx.recyclerview.widget.RecyclerView
import com.learn.bookhub.model.Book

class DashboardRecyclerAdapter(val context: Context, val itemList: ArrayList<Book>) : RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent,false)
        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val book = itemList[position]
        holder.txtBookName.text = book.bookName
        holder.txtBookAuthor.text = book.bookAuthor
        holder.txtBookPrice.text = book.bookCost
        holder.txtBookRating.text = book.bookRating
        holder.imgBookImage.setImageResource(book.bookImage)

        holder.l1Content.setOnClickListener{
            Toast.makeText(context,"Clicked on ${holder.txtBookName}",Toast.LENGTH_SHORT).show()
        }

    }

    class DashboardViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val txtBookName: TextView = view.findViewById(R.id.txtBookName)
        val txtBookAuthor: TextView = view.findViewById(R.id.txtBookAuthor)
        val txtBookPrice: TextView = view.findViewById(R.id.txtBookPrice)
        val txtBookRating: TextView = view.findViewById(R.id.txtBookRating)
        val imgBookImage: ImageView = view.findViewById(R.id.imgBookImage)
        val l1Content: LinearLayout = view.findViewById(R.id.l1Content)
    }
}