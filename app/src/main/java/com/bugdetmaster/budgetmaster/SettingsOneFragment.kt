package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.findNavController
import com.google.android.material.switchmaterial.SwitchMaterial


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
        view.findViewById<SwitchMaterial>(R.id.switch_LightDark).setOnClickListener {
/**
            if(view.findViewById<SwitchMaterial>(R.id.switch_LightDark).isEnabled){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    //Text auf ENABLE DARKMODE
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                //Text auf DISABLE DARKMODE
            }
*/

        }
    }

    /**
     * Die Methode [lightDarkMode] fragt ab, in welchem Modus sich das Handy aktuell befindet. Je nach Modus
     * wird das Bild-Objekt [lightDark_image] und der Switch angepasst. Im Lightmode ist das [lightDark_image]
     * ein nicht ausgefüllter Halbmond und der Switch ist nicht aktiviert. Im Darkmode ist [lightDark_image]
     * ein ausgefüllter Halbmond und der Switch ist aktiviert.
     */
    private fun lightDarkMode(switchMaterial: SwitchMaterial){

       if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO){
           view?.findViewById<SwitchMaterial>(R.id.switch_LightDark)?.isEnabled = false
            //Text auf ENABLE DARKMODE
        } else if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
           view?.findViewById<SwitchMaterial>(R.id.switch_LightDark)?.isEnabled = true
            //Text auf DISABLE DARKMODE
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}