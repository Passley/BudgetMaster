package com.bugdetmaster.budgetmaster

import android.graphics.drawable.Drawable
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
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class RegisterFragment : Fragment(R.layout.fragment_register) {
    final val TAG = "BUDGETMASTER"

    //Stellt den Email EditText nach
    lateinit var emailEditText: EditText
    //Stellt den Nutzernamen EditText nach
    lateinit var nutzernameEditText: EditText
    //Stellt den Passwort EditText nach
    lateinit var passwortEingabeEditText: EditText
    //Stellt den Passwort bestätigen EditText nach
    lateinit var passwortBestaetigenEditText: EditText
    //Stellt den Registrieren Button nach
    lateinit var registerButton: Button
    //Hinweistext
    lateinit var textHinweis: TextView


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
        super.onViewCreated(view, savedInstanceState)

        //Ordnet die Objekte den Variablen zu
        emailEditText = view.findViewById(R.id.Eingabe_Email2)
        nutzernameEditText = view.findViewById(R.id.Eingabe_Nutzername)
        passwortEingabeEditText = view.findViewById(R.id.Eingabe_passwort_erstellen)
        passwortBestaetigenEditText = view.findViewById(R.id.Eingabe_passwort_bestaetigen)
        registerButton = view.findViewById(R.id.Button_registrieren_fragReg)
        textHinweis = view.findViewById(R.id.Hinweis_Reg)
        textHinweis.visibility = View.GONE
        /**
         * Mit der kommenden Methode wird der Button "Anmelden?" mit der ID [Text_Anmelden] angesprochen.
         * Dieser hat mit der setClickListener-Methode die Aufgabe, den Benutzer auf das [LoginFragment] zu verweisen.
         * Der Navigationsgraph[nav_graph] kennt alle möglichen Routen vom aktuellen Fragment. Die action Variable erstellt die Route vom aktuellen Fragment zum [LoginFragment].
         * Die findNavController Klasse führt dann die Route aus.
         */
        view.findViewById<TextView>(R.id.Text_Anmelden).setOnClickListener {
            val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            findNavController().navigate(action)
        }

        /**
         * Mit der kommenden Methode wird der Button "Registrieren" mit der ID [Button_registrieren_fragReg] angesprochen.
         * Dieser hat mit der setClickListener-Methode die Aufgabe, den Benutzer auf das [UebersichtFragment] zu verweisen.
         * Der Navigationsgraph[nav_graph] kennt alle möglichen Routen vom aktuellen Fragment. Die action Variable erstellt die Route vom aktuellen Fragment zum [UebersichtFragment].
         * Die findNavController Klasse führt dann die Route aus.
         */

        registerButton.setOnClickListener {
            // Zeige die Navigationsleiste wieder an
            activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.VISIBLE

            // Zeige die ActionBar wieder an
            (requireActivity() as? AppCompatActivity)?.supportActionBar?.show()

            // Zeige die Top-Bar wieder an
            (requireActivity().findViewById(R.id.topAppBar) as? MaterialToolbar)?.visibility = View.VISIBLE
            val action = RegisterFragmentDirections.actionRegisterFragmentToUebersichtFragment()
            findNavController().navigate(action)
        }

        passwortBestaetigenEditText.addTextChangedListener(object : TextWatcher{
            override fun equals(other: Any?): Boolean {
                return super.equals(other)
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            //Prüft, ob Eingaben getätigt wurden und ob Passwort übereinstimmt. Aktiviert dann den [registerButton]
            override fun afterTextChanged(s: Editable?) {
                val email = emailEditText.text.toString()
                val nutzername = nutzernameEditText.text.toString()
                val passwort_1 = passwortEingabeEditText.text.toString()
                val passwort_2 = passwortBestaetigenEditText.text.toString()

                //Passt E-Mail?
                if (email != "" && (email.contains("@"))){
                    Log.i(TAG, "E-Mail ok")
                    //Passt Nutzername?
                    if (nutzername != ""){
                        Log.i(TAG, "Nutzername ok")
                        //Passt Passwörter?
                        if (passwort_1 == passwort_2){
                            Log.i(TAG, "Passwörter ok")
                            enabledButton(registerButton)
                        } else{
                           /** try {
                                textHinweis.text = "Passwörter stimmen nicht überein."
                                textHinweis.visibility = View.VISIBLE
                            } catch (e: Exception){ e.printStackTrace() } */
                        }
                    } else {
                        textHinweis.text = "Bitte fülle das Nutzernamen Feld aus."
                        textHinweis.visibility = View.VISIBLE
                    }
                } else {
                     textHinweis.text = "Bitte fülle das E-Mail Feld aus."
                     textHinweis.visibility = View.VISIBLE
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