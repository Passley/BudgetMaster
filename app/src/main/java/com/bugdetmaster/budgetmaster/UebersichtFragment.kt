package com.bugdetmaster.budgetmaster

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.OnBackPressedCallback


class UebersichtFragment : Fragment(R.layout.fragment_uebersicht) {

    private lateinit var progressBar: ProgressBar
    private lateinit var progressText: TextView
    private var percentage: Int = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialisiere ProgressBar und TextView
        progressBar = view.findViewById(R.id.progress_bar)
        progressText = view.findViewById(R.id.progressbar_text)

        //progress()

        //Den Zurückknopf für das aktuelle Fragment deaktivieren. Damit der User nicht mehr in den Login/SignUp Screen kommt.
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {}
        })


    }

    fun progress(){
        val ziel = 10000
        val aktuell = 5002
        val prozent = (aktuell.toDouble() / ziel.toDouble()) * 100
        prozent.toInt()
        // Handler wird verwendet, um die ProgressBar mit einem animierten Fortschritt zu aktualisieren
        val handler = Handler()
        progressText.text = "$aktuell/$ziel"
        // PostDelayed-Methode startet die Aktualisierung nach einer Verzögerung
        handler.postDelayed(object: Runnable{
            override fun run() {
                // Prüfe, ob der Fortschritt kleiner oder gleich 100 ist
                if (prozent>percentage) {
                    // aktualisiere die ProgressBar
                    progressBar.setProgress(percentage)
                    percentage++
                    // Wiederhole die Aktualisierung nach einer Verzögerung
                    handler.postDelayed(this, 200)
                } else {
                    // Entferne den Callback, wenn der Fortschritt 100 erreicht hat
                    handler.removeCallbacks(this)
                }
            }
        }, 200)
    }

}