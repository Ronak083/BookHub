package com.learn.bookhub.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo

class ConnectionManager {
    fun checkConnectivity(context: Context) : Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activieNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo

        if (activieNetwork?.isConnected != null){
            return activieNetwork.isConnected
        } else{
            return false
        }
    }
}