package com.learn.bookhub.fragment

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.learn.bookhub.R
import com.learn.bookhub.adapter.DashboardRecyclerAdapter
import com.learn.bookhub.model.Book
import com.learn.bookhub.util.ConnectionManager

class DashboardFragment : Fragment() {

    lateinit var recyclerDashboard: RecyclerView

    lateinit var layoutManager: RecyclerView.LayoutManager

    lateinit var btnCheckInernet: Button

    lateinit var recyclerAdapter: DashboardRecyclerAdapter

    val bookInfoList = arrayListOf<Book>(
        /*Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily),
        Book("Name @", "Ronak", "Rs. 299","4.5",R.drawable.ps_ily)

         */
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
                dialog.setTitle("Error")
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

        val queue = Volley.newRequestQueue(activity as Context)
        val url = "http://13.235.250.119/v1/book/fetch_books/"
        val jsonObjectRequest = object : JsonObjectRequest(Request.Method.GET, url,null, Response.Listener{
            val success = it.getBoolean("data")
            if (success){
                val data = it.getJSONArray("data")
                for (i in 0 until data.length()){
                    val bookJsonObject = data.getJSONObject(i)
                    val bookObject = Book(
                        bookJsonObject.getString("book_id"),
                        bookJsonObject.getString("name"),
                        bookJsonObject.getString("author"),
                        bookJsonObject.getString("rating"),
                        bookJsonObject.getString("price"),
                        bookJsonObject.getString("image")

                    )

                    bookInfoList.add(bookObject)
                    recyclerAdapter = DashboardRecyclerAdapter(activity as Context, bookInfoList)

                    recyclerDashboard.adapter = recyclerAdapter

                    recyclerDashboard.layoutManager = layoutManager

                    recyclerDashboard.addItemDecoration(
                        DividerItemDecoration(recyclerDashboard.context,
                            (layoutManager as LinearLayoutManager).orientation
                        )
                    )
                }

            } else{
                Toast.makeText(activity as Context,"",Toast.LENGTH_SHORT).show()
            }
        },Response.ErrorListener {
            println("Error is $it")
        }) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Content-type"] = "application/json"
                headers["token"] = "f4c7a03d1643a5"
                return headers
            }
        }

        queue.add(jsonObjectRequest)
        return view
    }

}
