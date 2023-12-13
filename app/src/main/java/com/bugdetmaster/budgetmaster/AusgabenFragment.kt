package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController

class AusgabenFragment : Fragment(R.layout.fragment_ausgaben) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Mit der kommenden Methode wird der Button "Hinzufügen" mit der ID addAusgabeButton angesprochen.
         * Dieser hat mit dem setClickListener-Methode die Aufgabe, den Benutzer auf das Fragment AusgabeErstellenFragment zu verweisen.
         * Der Navigationsgraph kennt alle möglichen Routen und die action Variable erstellt die Route vom aktuellen Fragment zum AusgabeErstellenFragment.
         * Die findNavController Klasse führt dann die Route aus.
         */
        view.findViewById<Button>(R.id.addAusgabeButton).setOnClickListener {
            val action = AusgabenFragmentDirections.actionAusgabenFragmentToAusgabeErstellenFragment()
            findNavController().navigate(action)
        }

        //Den Zurückknopf für das aktuelle Fragment deaktivieren. Damit der User nicht mehr in den Login/SignUp Screen kommt.
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {}
        })
    }
}