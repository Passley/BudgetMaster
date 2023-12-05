package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.Text_Registrieren).setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.button_anmelden).setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToUebersichtFragment()
            findNavController().navigate(action)
        }
   /**     view.findViewById<Button>(R.id.sign_in_button).setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToUebersichtFragment()
            findNavController().navigate(action)
        }*/
    }



}