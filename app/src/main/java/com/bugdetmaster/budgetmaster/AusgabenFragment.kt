package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class AusgabenFragment : Fragment(R.layout.fragment_ausgaben) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.addAusgabeButton).setOnClickListener {
            val action = AusgabenFragmentDirections.actionAusgabenFragmentToAusgabeErstellenFragment()
            findNavController().navigate(action)
        }
    }
}