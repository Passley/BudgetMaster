package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController

class AusgabenFragment : Fragment(R.layout.fragment_ausgaben) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.BTN_TEST).setOnClickListener {
            //Toast.makeText(activity, "ERFOLGREICH", Toast.LENGTH_SHORT).show()
            //val action = AusgabenFragmentDirections.actionAusgabenFragmentToAusgabeErstellenFragment()
            //findNavController().navigate(action)
        }



        /**
         * Mit der kommenden Methode wird der Button "Hinzufügen" mit der ID addAusgabeButton angesprochen.
         * Dieser hat mit dem setClickListener-Methode die Aufgabe, den Benutzer auf das Fragment AusgabeErstellenFragment zu verweisen.
         * Der Navigationsgraph kennt alle möglichen Routen und die action Variable erstellt die Route vom aktuellen Fragment zum AusgabeErstellenFragment.
         * Die findNavController Klasse führt dann die Route aus.
         */

        //Den Zurückknopf für das aktuelle Fragment deaktivieren. Damit der User nicht mehr in den Login/SignUp Screen kommt.
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {}
        })
    }
}