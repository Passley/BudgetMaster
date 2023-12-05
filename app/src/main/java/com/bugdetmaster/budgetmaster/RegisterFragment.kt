package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class RegisterFragment : Fragment(R.layout.fragment_register) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.Text_Anmelden).setOnClickListener {
            val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.Button_registrieren_fragReg).setOnClickListener {
            val action = RegisterFragmentDirections.actionRegisterFragmentToUebersichtFragment()
            findNavController().navigate(action)
        }

      /**  view.findViewById<Button>(R.id.sign_in_button1).setOnClickListener {
            val action = RegisterFragmentDirections.actionRegisterFragmentToUebersichtFragment()
            findNavController().navigate(action)
        } */
    }
}