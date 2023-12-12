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

class SettingsTwoFragment : Fragment(R.layout.fragment_settings_two) {
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

        view.findViewById<TextView>(R.id.btn_settings2_Abmelden).setOnClickListener {
            val action = SettingsTwoFragmentDirections.actionSettingsTwoFragmentToLoginFragment()
            findNavController().navigate(action)
        }
        view.findViewById<TextView>(R.id.btn_settings2_Kon_loeschen).setOnClickListener {
            val action = SettingsTwoFragmentDirections.actionSettingsTwoFragmentToKontoLoeschen()
            findNavController().navigate(action)
        }
        view.findViewById<TextView>(R.id.btn_settings2Pas_aendern).setOnClickListener {
            val action = SettingsTwoFragmentDirections.actionSettingsTwoFragmentToPasswortAendern()
            findNavController().navigate(action)
        }
        view.findViewById<TextView>(R.id.btn_settings2_Benut_aendern).setOnClickListener {
            val action = SettingsTwoFragmentDirections.actionSettingsTwoFragmentToBenutzernameAendern()
            findNavController().navigate(action)
        }
        view.findViewById<TextView>(R.id.sett_abbrechen).setOnClickListener {
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