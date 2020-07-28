package com.biodun.mindvalley.core

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NetworkHandler @Inject constructor(@ApplicationContext private val context: Context) {

    fun isConnected(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
}
