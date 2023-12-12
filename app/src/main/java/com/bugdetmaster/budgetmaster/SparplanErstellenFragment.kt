package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class SparplanErstellenFragment : Fragment(R.layout.fragment_sparplan_erstellen) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Verstecke die Navigationsleiste, wenn dieses Fragment angezeigt wird
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.GONE

        // Verstecke die ActionBar (Top-Bar), wenn dieses Fragment angezeigt wird
        (requireActivity() as? AppCompatActivity)?.supportActionBar?.hide()

        // Verstecke die TopAppBar, wenn dieses Fragment angezeigt wird
        (requireActivity().findViewById(R.id.topAppBar) as? MaterialToolbar)?.visibility = View.GONE

        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Mit der kommenden Methode wird der Button "Sparplan erstellen" mit der ID Button_Sparplan_Erstellen angesprochen.
         * Dieser hat mit dem setClickListener-Methode die Aufgabe, den Benutzer auf das Fragment SparplanFragment zu verweisen.
         * Der Navigationsgraph kennt alle möglichen Routen und die action Variable erstellt die Route vom aktuellen Fragment zum SparplanFragment.
         * Die findNavController Klasse führt dann die Route aus.
         */
        view.findViewById<Button>(R.id.Button_Sparplan_Erstellen).setOnClickListener {
            val action = SparplanErstellenFragmentDirections.actionSparplanErstellenFragmentToSparplanFragment()
            findNavController().navigate(action)
        }
        /**
         * Mit der kommenden Methode wird der Button "Abbrechen" mit der ID button_Sparplan_Abbrechen angesprochen.
         * Dieser hat mit dem setClickListener-Methode die Aufgabe, den Benutzer auf das Fragment SparplanFragment zu verweisen.
         * Der Navigationsgraph kennt alle möglichen Routen und die action Variable erstellt die Route vom aktuellen Fragment zum SparplanFragment.
         * Die findNavController Klasse führt dann die Route aus.
         */
        view.findViewById<Button>(R.id.button_Sparplan_Abbrechen).setOnClickListener {
            val action = SparplanErstellenFragmentDirections.actionSparplanErstellenFragmentToSparplanFragment()
            findNavController().navigate(action)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()

        // Zeige die Navigationsleiste wieder an, wenn das Fragment zerstört wird
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.VISIBLE

        // Zeige die ActionBar (Top-Bar) wieder an, wenn das Fragment zerstört wird
        (requireActivity() as? AppCompatActivity)?.supportActionBar?.show()

        // Zeige die TopAppBar wieder an, wenn das Fragment zerstört wird
        (requireActivity().findViewById(R.id.topAppBar) as? MaterialToolbar)?.visibility = View.VISIBLE
    }
}