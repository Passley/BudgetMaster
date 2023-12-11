package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class SparplanFragment : Fragment(R.layout.fragment_sparplan) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.button_sparplan_erstellen).setOnClickListener {
            val action = SparplanFragmentDirections.actionSparplanFragmentToSparplanErstellenFragment()
            findNavController().navigate(action)
        }
    }
}