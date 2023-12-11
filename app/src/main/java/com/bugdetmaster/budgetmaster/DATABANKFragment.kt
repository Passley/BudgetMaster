package com.bugdetmaster.budgetmaster

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.UiThread
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class DATABANKFragment : Fragment(R.layout.fragment_d_a_t_a_b_a_n_k) {

    private val client = OkHttpClient()
    private lateinit var text: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text = view.findViewById<TextView>(R.id.DATA_TEXT)

        view.findViewById<Button>(R.id.DATA_BUTTON).setOnClickListener {
            try {
                activity?.runOnUiThread {
                    run("https://api.github.com/users/Passley/repos")
                }
            } catch (e: Exception){
                Log.e("ERROR DATA", "COULD NOUT DISPLAY DATA")
            }

        }
    }

    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                text.text = "FAILED"
            }
            override fun onResponse(call: Call, response: Response) {

                Log.i("DATA", "${response.body()?.string()}")
               // println(response.body()?.string())
            }
        })
    }
}