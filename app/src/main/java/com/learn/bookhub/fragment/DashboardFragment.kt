package com.learn.bookhub.fragment

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.learn.bookhub.R
import com.learn.bookhub.adapter.DashboardRecyclerAdapter
import com.learn.bookhub.model.Book
import com.learn.bookhub.util.ConnectionManager

class DashboardFragment : Fragment() {

    lateinit var recyclerDashboard: RecyclerView

    lateinit var layoutManager: RecyclerView.LayoutManager

    lateinit var btnCheckInernet: Button

    val bookList = arrayListOf(
        "P.S. I love You", "The Great Gateby", "Book 3", "Book 4","Book 5","Book 6","Book 7","Book 8","Book 9","Book 10")

    lateinit var recyclerAdapter: DashboardRecyclerAdapter

    val bookInfoList = arrayListOf<Book>(
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        recyclerDashboard = view.findViewById(R.id.recyclerDashboard)

        btnCheckInernet = view.findViewById(R.id.btnCheckInternet)
        btnCheckInernet.setOnClickListener{
            if (ConnectionManager().checkConnectivity(activity as Context)){
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Success")
                dialog.setMessage("Internet Connection Found")
                dialog.setPositiveButton("OK"){text,listner ->

                }
                dialog.setNegativeButton("Cancel"){text, listner ->

                }

                dialog.create()
                dialog.show()

            } else{
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Success")
                dialog.setMessage("No Internet Connection Found")
                dialog.setPositiveButton("Ok"){text,listner ->

                }
                dialog.setNegativeButton("Cancel"){text, listner ->

                }
                dialog.create()
                dialog.show()
            }
        }

        layoutManager = LinearLayoutManager(activity)

        recyclerAdapter = DashboardRecyclerAdapter(activity as Context, bookInfoList)

        recyclerDashboard.adapter = recyclerAdapter

        recyclerDashboard.layoutManager = layoutManager

        recyclerDashboard.addItemDecoration(
            DividerItemDecoration(recyclerDashboard.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )

        return view
    }

}
