package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView


class Passwort_aendern : Fragment(R.layout.fragment_passwort_aendern) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Mit der kommenden Methode wird der Button "Fertig" mit der ID btn_passworaendern_pass_fert angesprochen.
         * Dieser hat mit dem setClickListener-Methode die Aufgabe, den Benutzer auf das Fragment SettingsTwoFragment zu verweisen.
         * Der Navigationsgraph kennt alle möglichen Routen und die action Variable erstellt die Route vom aktuellen Fragment zum SettingsTwoFragment.
         * Die findNavController Klasse führt dann die Route aus.
         */
        view.findViewById<TextView>(R.id.btn_passworaendern_pass_fert).setOnClickListener {
            val action = Passwort_aendernDirections.actionPasswortAendernToSettingsTwoFragment()
            findNavController().navigate(action)
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Verstecke die Navigationsleiste, wenn dieses Fragment angezeigt wird
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.GONE
        return inflater.inflate(R.layout.fragment_passwort_aendern, container, false)
    }


}