package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.switchmaterial.SwitchMaterial


class SettingsOneFragment : Fragment(R.layout.fragment_settings_one) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lightDarkMode(view.findViewById<SwitchMaterial>(R.id.switch_LightDark))


        view.findViewById<SwitchMaterial>(R.id.switch_LightDark).setOnClickListener {

           /** if(view.findViewById<SwitchMaterial>(R.id.switch_LightDark).isEnabled){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    //Text auf ENABLE DARKMODE
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                //Text auf DISABLE DARKMODE
            }

                */
        }
    }

    private fun lightDarkMode(switchMaterial: SwitchMaterial){

       /** if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO){
            boolean = false
            //Text auf ENABLE DARKMODE
        } else if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            boolean = true
            //Text auf DISABLE DARKMODE
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } */
    }
}