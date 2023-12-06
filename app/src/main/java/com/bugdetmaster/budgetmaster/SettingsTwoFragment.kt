package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class SettingsTwoFragment : Fragment(R.layout.fragment_settings_two) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**view.findViewById<Button>(R.id.btn_settings2konto).setOnClickListener {
            val action = SettingsTwoFragmentDirections.actionSettingsTwoFragmentToSettingsOneFragment()
            findNavController().navigate(action)
        } */
    }
}