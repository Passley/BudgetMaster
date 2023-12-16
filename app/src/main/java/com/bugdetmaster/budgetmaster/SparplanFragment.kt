package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController


class SparplanFragment : Fragment(R.layout.fragment_sparplan) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Mit der kommenden Methode wird der Button "Sparplan erstellen" mit der ID button_sparplan_erstellen angesprochen.
         * Dieser hat mit dem setClickListener-Methode die Aufgabe, den Benutzer auf das Fragment SparplanErstellenFragment zu verweisen.
         * Der Navigationsgraph kennt alle möglichen Routen und die action Variable erstellt die Route vom aktuellen Fragment zum SparplanErstellenFragment.
         * Die findNavController Klasse führt dann die Route aus.
         */
        view.findViewById<Button>(R.id.button_sparplan_erstellen1).setOnClickListener {
            val action = SparplanFragmentDirections.actionSparplanFragmentToSparplanErstellenFragment()
            findNavController().navigate(action)
        }

        //Den Zurückknopf für das aktuelle Fragment deaktivieren. Damit der User nicht mehr in den Login/SignUp Screen kommt.
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {}
        })
    }
}