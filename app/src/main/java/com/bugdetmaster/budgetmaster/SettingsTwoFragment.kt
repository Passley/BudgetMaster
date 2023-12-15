package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class SettingsTwoFragment : Fragment(R.layout.fragment_settings_two) {

    //Stellt den Zurück Button nach
    lateinit var zurückButton: Button
    //Stellt den Abmelden Button nach
    lateinit var abmeldenButton: Button
    //Stellt den Kontoloeschen Button nach
    lateinit var kontoloeschenButton: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Verstecke die Navigationsleiste, wenn dieses Fragment angezeigt wird
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.GONE

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Verbindet Variablen mit Objekten in Layout
        zurückButton = view.findViewById(R.id.sett_abbrechen)
        abmeldenButton = view.findViewById(R.id.btn_settings2_Abmelden)
        kontoloeschenButton = view.findViewById(R.id.btn_settings2_Kon_loeschen)


        abmeldenButton.setOnClickListener {
            //toDo: Methode fürs abmelden

            Toast.makeText(activity,"Du wurdest erfolgreich abgemeldet", Toast.LENGTH_SHORT).show()

            val action = SettingsTwoFragmentDirections.actionSettingsTwoFragmentToLoginFragment()
            findNavController().navigate(action)
        }

        kontoloeschenButton.setOnClickListener {
            //toDo: Methode fürs löschen

            Toast.makeText(activity,"Konto wurde erfolgreich gelöscht",Toast.LENGTH_SHORT).show()

            val action = SettingsTwoFragmentDirections.actionSettingsTwoFragmentToKontoLoeschen()
            findNavController().navigate(action)
        }


        zurückButton.setOnClickListener {
            // Zeige die Navigationsleiste wieder an
            activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.VISIBLE

            // Zeige die ActionBar wieder an
            (requireActivity() as? AppCompatActivity)?.supportActionBar?.show()

            // Zeige die Top-Bar wieder an
            (requireActivity().findViewById(R.id.topAppBar) as? MaterialToolbar)?.visibility = View.VISIBLE

            // Navigiere zum vorherigen Fragment
            val action = SettingsTwoFragmentDirections.actionSettingsTwoFragmentToSettingsOneFragment()
            findNavController().navigate(action)
        }
    }


}