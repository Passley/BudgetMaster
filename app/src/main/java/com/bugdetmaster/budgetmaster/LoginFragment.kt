package com.bugdetmaster.budgetmaster

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView


class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Verstecke die Navigationsleiste, wenn dieses Fragment angezeigt wird
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.GONE

        // Verstecke die ActionBar (Top-Bar), wenn dieses Fragment angezeigt wird
        (requireActivity() as? AppCompatActivity)?.supportActionBar?.hide()

        // Verstecke die TopAppBar, wenn dieses Fragment angezeigt wird
        (requireActivity().findViewById(R.id.topAppBar) as? MaterialToolbar)?.visibility = View.GONE

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Verstecke die Navigationsleiste, wenn dieses Fragment angezeigt wird
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.GONE
        (requireActivity() as? AppCompatActivity)?.supportActionBar?.hide()
        (requireActivity().findViewById(R.id.topAppBar) as? MaterialToolbar)?.visibility = View.GONE

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
        /**view.findViewById<Button>(R.id.sign_in_button).setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToUebersichtFragment()
            findNavController().navigate(action)
        } */

    }
    override fun onDestroyView() {
        super.onDestroyView()

        // Zeige die Navigationsleiste wieder an, wenn das Fragment zerstört wird
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.VISIBLE

        // Zeige die ActionBar (Top-Bar) wieder an, wenn das Fragment zerstört wird
        (requireActivity() as? AppCompatActivity)?.supportActionBar?.show()

        // Zeige die TopAppBar wieder an, wenn das Fragment zerstört wird
        (requireActivity().findViewById(R.id.topAppBar) as? MaterialToolbar)?.visibility = View.VISIBLE
    }


}

