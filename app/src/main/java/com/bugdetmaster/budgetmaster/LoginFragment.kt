package com.bugdetmaster.budgetmaster

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView


class LoginFragment : Fragment(R.layout.fragment_login) {
    final val TAG = "BUDGETMASTER"

    //Stellt den Email EditText nach
    lateinit var emailEditText: EditText

    //Stellt den Passwort EditText nach
    lateinit var passwortEingabeEditText: EditText

    //Stellt den Registrieren Button nach
    lateinit var anmeldeButton: Button
    //Stellt den Google Button nach
    lateinit var googleButton: Button
    //Hinweistext - aktuell nicht drin
    //lateinit var textHinweis: TextView


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

        //Ordnet die Objekte den Variablen zu
        emailEditText = view.findViewById(R.id.Eingabe_Email)
        passwortEingabeEditText = view.findViewById(R.id.Eingabe_Password)
        anmeldeButton = view.findViewById(R.id.button_anmelden)
        googleButton = view.findViewById(R.id.sign_in_button)

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
        anmeldeButton.setOnClickListener {
            // Zeige die Navigationsleiste wieder an
            activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.VISIBLE

            // Zeige die ActionBar wieder an
            (requireActivity() as? AppCompatActivity)?.supportActionBar?.show()

            // Zeige die Top-Bar wieder an
            (requireActivity().findViewById(R.id.topAppBar) as? MaterialToolbar)?.visibility = View.VISIBLE
            val action = LoginFragmentDirections.actionLoginFragmentToUebersichtFragment()
            findNavController().navigate(action)
        }

        /**
         * Mit der kommenden Methode wird der Google Login Button mit der ID [sign_in_button] angesprochen.
         * Dieser hat mit der setClickListener-Methode die Aufgabe, den Benutzer auf das [UebersichtFragment] zu verweisen.
         * Der Navigationsgraph[nav_graph] kennt alle möglichen Routen vom aktuellen Fragment. Die action Variable erstellt die Route vom aktuellen Fragment zum [UebersichtFragment].
         * Die findNavController Klasse führt dann die Route aus.
        */
        googleButton.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToUebersichtFragment()
            findNavController().navigate(action)
        }

        passwortEingabeEditText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            //Prüft, ob Eingaben getätigt wurden. Aktiviert dann den [anmeldeButton/button_anmelden]
            override fun afterTextChanged(s: Editable?) {
                val email = emailEditText.text.toString()
                val passwort = passwortEingabeEditText.text.toString()

                //Passt E-Mail?
                if (email != "" && (email.contains("@"))){
                    Log.i(TAG, "E-Mail ok")
                    //Passwort drin?
                    if (passwort != ""){
                        Log.i(TAG, "Passwort ok")
                        enabledButton(anmeldeButton)
                        enabledButton(googleButton)
                    }
                } else {
                    Toast.makeText(activity, "Bitte fülle das E-Mail Feld aus.", Toast.LENGTH_SHORT).show()
                }
            }
        })

    }


    //Prüft ob der Button enabled ist oder nicht. Dadurch ändert sich der Zustand bzw. Farbe des Buttons
    fun enabledButton(button: Button){
        if(!button.isEnabled){
            button.isEnabled = true
        }
    }
}

