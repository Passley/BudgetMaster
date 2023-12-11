package com.bugdetmaster.budgetmaster

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView


class UebersichtFragment : Fragment(R.layout.fragment_uebersicht) {

    private lateinit var progressBar: ProgressBar
    private lateinit var progressText: TextView
    private var percentage: Int = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = view.findViewById(R.id.progress_bar)
        progressText = view.findViewById(R.id.progressbar_text)


        val handler = Handler()
        handler.postDelayed(object: Runnable{
            override fun run() {
                if (percentage <= 100) {
                    progressText.text = "" + percentage
                    progressBar.setProgress(percentage)
                    percentage++
                    handler.postDelayed(this, 200)
                } else {
                    handler.removeCallbacks(this)
                }
            }
        }, 200)

    }

}