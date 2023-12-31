package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class AusgabeErstellenFragment : Fragment(R.layout.fragement_ausgaben_erstellen) {

    // Deklaration der UI-Elemente
    lateinit var abbrechenAusgabeButton: Button
    lateinit var ausgabeErstellenButton: Button
    lateinit var ausgabeEditText: EditText
    lateinit var ausgaeBeschreibungEditText: EditText
    lateinit var ausgabeDatumEditText: EditText
    lateinit var ausgabeBeitragEditText: EditText
    lateinit var ausgabeKategorieEditText: EditText

    // Hier wird die View für das Fragment erstellt
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Verstecke die Bottom Navigation View, wenn dieses Fragment angezeigt wird
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.GONE

        // Verstecke die ActionBar (Top-Bar), wenn dieses Fragment angezeigt wird
        (requireActivity() as? AppCompatActivity)?.supportActionBar?.hide()

        // Verstecke die TopAppBar, wenn dieses Fragment angezeigt wird
        (requireActivity().findViewById(R.id.topAppBar) as? MaterialToolbar)?.visibility = View.GONE

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    // Hier wird die Logik für die Interaktion mit den UI-Elementen festgelegt
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialisiere die UI-Elemente durch ihre IDs in der erstellten View
        abbrechenAusgabeButton = view.findViewById(R.id.Button_Abbrechen_ausgabe)
        ausgabeErstellenButton = view.findViewById(R.id.Button_Ausgabe_Erstellen)
        ausgabeEditText = view.findViewById(R.id.Eingabe_Ausgabe)
        ausgaeBeschreibungEditText = view.findViewById(R.id.Eingabe_Beschreibung)
        ausgabeDatumEditText = view.findViewById(R.id.Eingabe_Datum)
        ausgabeBeitragEditText = view.findViewById(R.id.Eingabe_Beitrag)
        ausgabeKategorieEditText = view.findViewById(R.id.Kategorie)

        // Setze die OnClickListener für die Buttons
        ausgabeErstellenButton.setOnClickListener{
            val action = AusgabeErstellenFragmentDirections.actionAusgabeErstellenFragmentToAusgabenFragment()
            findNavController().navigate(action)
        }

        abbrechenAusgabeButton.setOnClickListener {
            val action = AusgabeErstellenFragmentDirections.actionAusgabeErstellenFragmentToAusgabenFragment()
            findNavController().navigate(action)
        }
    }

    // Wird aufgerufen, wenn das Fragment zerstört wird
    override fun onDestroyView() {
        super.onDestroyView()

        // Zeige die Bottom Navigation View wieder an, wenn das Fragment zerstört wird
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.VISIBLE

        // Zeige die ActionBar (Top-Bar) wieder an, wenn das Fragment zerstört wird
        (requireActivity() as? AppCompatActivity)?.supportActionBar?.show()

        // Zeige die TopAppBar wieder an, wenn das Fragment zerstört wird
        (requireActivity().findViewById(R.id.topAppBar) as? MaterialToolbar)?.visibility = View.VISIBLE
    }
}
