package com.bugdetmaster.budgetmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class TutorialFragment : Fragment(R.layout.fragment_tutorial) {

    //Counter der Tutorial Bilder nacheinander aufzeigt
    private var counter = 0

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


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tutorial, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Verstecke die Navigationsleiste, wenn dieses Fragment angezeigt wird
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.GONE
        (requireActivity() as? AppCompatActivity)?.supportActionBar?.hide()
        (requireActivity().findViewById(R.id.topAppBar) as? MaterialToolbar)?.visibility = View.GONE

        super.onViewCreated(view, savedInstanceState)

        //Den Zurückknopf für das aktuelle Fragment deaktivieren. Damit der User nicht mehr in den Login/SignUp Screen kommt.
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {}
        })


        //Findet den Button [floating_action_button] und sagt was nach dem Click passieren soll.
        view.findViewById<FloatingActionButton>(R.id.floating_action_button).setOnClickListener {
            Snackbar.make(requireActivity().findViewById(android.R.id.content), "Text label", Snackbar.LENGTH_INDEFINITE)
                .show()


            /**
             * // Zeige die Navigationsleiste wieder an
             *             activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.VISIBLE
             *
             *             // Zeige die ActionBar wieder an
             *             (requireActivity() as? AppCompatActivity)?.supportActionBar?.show()
             *
             *             // Zeige die Top-Bar wieder an
             *             (requireActivity().findViewById(R.id.topAppBar) as? MaterialToolbar)?.visibility = View.VISIBLE
             */
        }


    }
}