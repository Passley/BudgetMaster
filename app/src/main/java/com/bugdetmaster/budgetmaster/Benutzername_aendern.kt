package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class Benutzername_aendern : Fragment(R.layout.fragment_benutzername_aendern) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Verstecke die Navigationsleiste, wenn dieses Fragment angezeigt wird
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.GONE

        return inflater.inflate(R.layout.fragment_benutzername_aendern, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Mit der kommenden Methode wird der Button "Bestätigen" mit der ID btn_benutzeraendern_bestaetigen angesprochen.
         * Dieser hat mit dem setClickListener-Methode die Aufgabe, den Benutzer auf das Fragment SettingsTwoFragment zu verweisen.
         * Der Navigationsgraph kennt alle möglichen Routen und die action Variable erstellt die Route vom aktuellen Fragment zum SettingsTwoFragment.
         * Die findNavController Klasse führt dann die Route aus.
         */
        view.findViewById<TextView>(R.id.btn_benutzeraendern_bestaetigen).setOnClickListener {
            val action = Benutzername_aendernDirections.actionBenutzernameAendernToSettingsTwoFragment()
            findNavController().navigate(action)
        }

    }

}