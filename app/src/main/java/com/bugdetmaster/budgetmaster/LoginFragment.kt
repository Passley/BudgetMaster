package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /**
         * Mit der kommenden Methode wird der Button "Registrieren?" mit der ID Text_RegistrierenButton angesprochen.
         * Dieser hat mit der setClickListener-Methode die Aufgabe, den Benutzer auf das RegistrierenFragment zu verweisen.
         * Der Navigationsgraph kennt alle möglichen Routen vom aktuellen Fragment. Die action Variable erstellt die Route vom aktuellen Fragment zum RegistrierenFragment.
         * Die findNavController Klasse führt dann die Route aus.
         */
        view.findViewById<TextView>(R.id.Text_Registrieren).setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            findNavController().navigate(action)
        }

        /**
         * Mit der kommenden Methode wird der Button "Anmelden" mit der ID [button_anmelden] angesprochen.
         * Dieser hat mit der setClickListener-Methode die Aufgabe, den Benutzer auf das [UebersichtFragment] zu verweisen.
         * Der Navigationsgraph[nav_graph] kennt alle möglichen Routen vom aktuellen Fragment. Die action Variable erstellt die Route vom aktuellen Fragment zum [UebersichtFragment].
         * Die findNavController Klasse führt dann die Route aus.
         */
        view.findViewById<Button>(R.id.button_anmelden).setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToUebersichtFragment()
            findNavController().navigate(action)
        }

        /**
         * Mit der kommenden Methode wird der Google Login Button mit der ID [sign_in_button] angesprochen.
         * Dieser hat mit der setClickListener-Methode die Aufgabe, den Benutzer auf das [UebersichtFragment] zu verweisen.
         * Der Navigationsgraph[nav_graph] kennt alle möglichen Routen vom aktuellen Fragment. Die action Variable erstellt die Route vom aktuellen Fragment zum [UebersichtFragment].
         * Die findNavController Klasse führt dann die Route aus.
        */
        view.findViewById<Button>(R.id.sign_in_button).setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToUebersichtFragment()
            findNavController().navigate(action)
        }
    }



}