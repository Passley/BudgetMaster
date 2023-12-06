package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.switchmaterial.SwitchMaterial


class SettingsOneFragment : Fragment(R.layout.fragment_settings_one) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<SwitchMaterial>(R.id.switch_LightDark).setOnClickListener {  }
    }
}