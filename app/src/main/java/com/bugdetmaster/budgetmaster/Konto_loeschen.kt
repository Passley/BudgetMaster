package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class Konto_loeschen : Fragment(R.layout.fragment_konto_loeschen) {
    lateinit var kontoLoeschenButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Verbindet Variable mit Button
        kontoLoeschenButton = view.findViewById(R.id.btn_kontoloesch_bestaetigen)

        /**
         * Mit der kommenden Methode wird der Button "Bestätigen" mit der ID btn_kontoloesch_bestaetigen angesprochen.
         * Dieser hat mit dem setClickListener-Methode die Aufgabe, den Benutzer auf das Fragment LoginFragment zu verweisen.
         * Der Navigationsgraph kennt alle möglichen Routen und die action Variable erstellt die Route vom aktuellen Fragment zum LoginFragment.
         * Die findNavController Klasse führt dann die Route aus.
         */
        kontoLoeschenButton.setOnClickListener {
            Toast.makeText(activity,"Konto wurde erfolgreich gelöscht", Toast.LENGTH_SHORT).show()
            val action = Konto_loeschenDirections.actionKontoLoeschenToLoginFragment()
            findNavController().navigate(action)
        }

        //Den Zurückknopf für das aktuelle Fragment deaktivieren. Damit der User nicht mehr in den Login/SignUp Screen kommt.
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {}
        })
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Verstecke die Navigationsleiste, wenn dieses Fragment angezeigt wird
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.GONE
        return inflater.inflate(R.layout.fragment_konto_loeschen, container, false)
    }

}