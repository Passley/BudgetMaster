package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.switchmaterial.SwitchMaterial
import android.content.SharedPreferences
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment


const val KEY_DARK_MODE = "dark_mode"

class SettingsOneFragment : Fragment(R.layout.fragment_settings_one) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Die Methode [lightDarkMode] wird bei jedem Aufruf des Fragments ausgeführt.
         */
        lightDarkMode(view.findViewById<SwitchMaterial>(R.id.switch_LightDark))

        view.findViewById<TextView>(R.id.btn_kontosettings).setOnClickListener {
            val action = SettingsOneFragmentDirections.actionSettingsOneFragmentToSettingsTwoFragment()
            findNavController().navigate(action)
        }

        /**
         * Mit der kommenden Methode wird der Switch mit der ID [switch_LightDark] angesprochen.
         * Mit der setOnClickListener Methode kann der Light- oder Darkmode aktiviert werden.
         * In der Methode wird abgefragt, in welchem Status sich der Switch befindet. Falls der Switch
         * aktiviert ist, wird in den Lightmode gewechselt. Anderenfalls wird der Darkmode aktiviert.
         */
        view.findViewById<SwitchMaterial>(R.id.switch_LightDark).setOnCheckedChangeListener { _, isChecked ->
            // Aktualisiere den Dark Mode basierend auf dem Schalterstatus
            updateDarkMode(isChecked)
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Verstecke die Navigationsleiste, wenn dieses Fragment angezeigt wird
        (requireActivity() as? AppCompatActivity)?.supportActionBar?.hide()
        (requireActivity().findViewById(R.id.topAppBar) as? MaterialToolbar)?.visibility = View.GONE

        return super.onCreateView(inflater, container, savedInstanceState)
    }
    /**
     * Die Methode [lightDarkMode] fragt ab, in welchem Modus sich das Handy aktuell befindet. Je nach Modus
     * wird das Bild-Objekt [lightDark_image] und der Switch angepasst. Im Lightmode ist das [lightDark_image]
     * ein nicht ausgefüllter Halbmond und der Switch ist nicht aktiviert. Im Darkmode ist [lightDark_image]
     * ein ausgefüllter Halbmond und der Switch ist aktiviert.
     */
// Die Methode [updateDarkMode] aktualisiert den Dark Mode basierend auf dem Schalterstatus
    private fun updateDarkMode(isChecked: Boolean) {
        if (isChecked) {
            // Dark Mode aktivieren
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            // Dark Mode deaktivieren
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
    private fun lightDarkMode(switchMaterial: SwitchMaterial) {
        // Überprüfe den aktuellen Dark Mode-Status
        val isDarkMode = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES

        // Setze den Switch-Status basierend auf dem Dark Mode-Status
        switchMaterial.isChecked = isDarkMode
    }
    override fun onDestroyView() {
        super.onDestroyView()
        // Zeige die Navigationsleiste wieder an, wenn das Fragment zerstört wird
        (requireActivity() as? AppCompatActivity)?.supportActionBar?.show()
        (requireActivity().findViewById(R.id.topAppBar) as? MaterialToolbar)?.visibility = View.VISIBLE

    }
}