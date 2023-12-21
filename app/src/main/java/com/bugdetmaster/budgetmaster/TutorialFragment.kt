package com.bugdetmaster.budgetmaster

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

/**
 * Das [TutorialFragment] zeigt dem User einen Überblick über die Hauptfragments und die Bottombar an.
 * Dafür werden dem User Screenshots eingeblendet und ein Text dient als Beschreibung.
 */
class TutorialFragment : Fragment(R.layout.fragment_tutorial) {

    //Counter der Tutorial Bilder nacheinander aufzeigt
    private var counter = 0

    //Das Image
    lateinit var imageView: ImageView
    //Das Layout
    lateinit var LinearLayout: LinearLayout
    //Der Beschreibungstext
    lateinit var textView: TextView
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

        imageView = view.findViewById(R.id.Bild_Tutorial1)
        imageView.visibility = View.VISIBLE
        imageView.setImageResource(R.drawable.bild2)
        LinearLayout = view.findViewById(R.id.linear_layout_Tutorial)
        textView = view.findViewById(R.id.text_Tutorial)


        //Findet den Button [floating_action_button] und sagt was nach dem Click passieren soll.
        view.findViewById<FloatingActionButton>(R.id.floating_action_button).setOnClickListener {
            switchingImages(textView,LinearLayout,imageView)
        }
    }

    /**
     * Bestimmt durch die Variable [counter], den aktuellen Status, wo sich der User im Tutorial befindet.
     * Die Zahl des Counters erhöht sich, sobald auf das nächste Bild gewechselt werden soll. Beim letzten
     * Bild wird der Counter wieder auf den Anfangszustand gesetzt.
     */
    fun switchingImages(textView: TextView, LinearLayout: LinearLayout, imageView: ImageView){
        when(counter){
            0 -> {
                imageView.setImageResource(R.drawable.bild1)
                textView.text = "Text für die Bottombar"
                counter = 1
            }
            1 -> {
                textView.text = "Text für die Übersicht"
                imageView.setImageResource(R.drawable.bild2)
                counter = 2
            }
            2 -> {
                textView.text = "Text für 2te Ding in Bottombar"
                imageView.setImageResource(R.drawable.bild3)
                counter = 3
            }
            3 -> {
                textView.text = "Text für 3te Ding in Bottombar"
                imageView.setImageResource(R.drawable.bild4)
                counter = 4
            }
            4 -> {
                textView.text = "Text für 4te Ding in Bottombar"
                imageView.setImageResource(R.drawable.bild5)
                counter = 5

            }
            5 -> {
                textView.text = "Viel Spaß noch!"
                counter = 6
            }
            6 -> {
                counter = 0
                val action = TutorialFragmentDirections.actionTutorialFragmentToSettingsOneFragment()
                findNavController().navigate(action)

                // Zeige die Navigationsleiste wieder an
                activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.VISIBLE
                // Zeige die ActionBar wieder an
                (requireActivity() as? AppCompatActivity)?.supportActionBar?.show()
                // Zeige die Top-Bar wieder an
                (requireActivity().findViewById(R.id.topAppBar) as? MaterialToolbar)?.visibility = View.VISIBLE
            }
        }
    }
}