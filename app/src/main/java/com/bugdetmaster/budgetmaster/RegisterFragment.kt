package com.bugdetmaster.budgetmaster

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.bugdetmaster.budgetmaster.data.RetrofitApi
import com.bugdetmaster.budgetmaster.data.login.SignUp
import com.bugdetmaster.budgetmaster.data.login.SignUpResponse
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Date

class RegisterFragment : Fragment(R.layout.fragment_register) {
    //Tag für die Konsole
    final val TAG = "BUDGETMASTER"

    //Stellt den Email EditText nach
    lateinit var emailEditText: EditText
    //Stellt den Vornamen EditText nach
    lateinit var vornameEditText: EditText
    //Stellt den Nachnamen EditText nach
    lateinit var nachnameEditText: EditText
    //Stellt den Nutzernamen EditText nach
    lateinit var nutzernameEditText: EditText
    //Stellt den Passwort EditText nach
    lateinit var passwortEingabeEditText: EditText
    //Stellt den Passwort bestätigen EditText nach
    lateinit var passwortBestaetigenEditText: EditText
    //Stellt den Registrieren Button nach
    lateinit var registerButton: Button

    //Die URL des Servers
    val BASE_URL = "http://85.215.77.230/"

    companion object{
        lateinit var Api: Retrofit
    }

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

        //Ordnet die Objekte den Variablen zu
        emailEditText = view.findViewById(R.id.Eingabe_Email2)
        nutzernameEditText = view.findViewById(R.id.Eingabe_Nutzername)
        passwortEingabeEditText = view.findViewById(R.id.Eingabe_passwort_erstellen)
        passwortBestaetigenEditText = view.findViewById(R.id.Eingabe_passwort_bestaetigen)
        registerButton = view.findViewById(R.id.Button_registrieren_fragReg)
        vornameEditText = view.findViewById(R.id.Eingabe_Vorname)
        nachnameEditText = view.findViewById(R.id.Eingabe_Nachname)

        /**
         * Mit der kommenden Methode wird der Button "Anmelden?" mit der ID [Text_Anmelden] angesprochen.
         * Dieser hat mit der setClickListener-Methode die Aufgabe, den Benutzer auf das [LoginFragment] zu verweisen.
         * Der Navigationsgraph[nav_graph] kennt alle möglichen Routen vom aktuellen Fragment. Die action Variable erstellt die Route vom aktuellen Fragment zum [LoginFragment].
         * Die findNavController Klasse führt dann die Route aus.
         */
        view.findViewById<TextView>(R.id.Text_Anmelden).setOnClickListener {
            val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            findNavController().navigate(action)
        }

        /**
         * Mit der kommenden Methode wird der Button "Registrieren" mit der ID [Button_registrieren_fragReg] angesprochen.
         * Dieser hat mit der setClickListener-Methode die Aufgabe, den Benutzer auf das [UebersichtFragment] zu verweisen.
         * Der Navigationsgraph[nav_graph] kennt alle möglichen Routen vom aktuellen Fragment. Die action Variable erstellt die Route vom aktuellen Fragment zum [UebersichtFragment].
         * Die findNavController Klasse führt dann die Route aus.
         */

        registerButton.setOnClickListener {
            // Zeige die Navigationsleiste wieder an
            activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.VISIBLE

            // Zeige die ActionBar wieder an
            (requireActivity() as? AppCompatActivity)?.supportActionBar?.show()

            // Zeige die Top-Bar wieder an
            (requireActivity().findViewById(R.id.topAppBar) as? MaterialToolbar)?.visibility = View.VISIBLE
            signUP()
            val action = RegisterFragmentDirections.actionRegisterFragmentToUebersichtFragment()
            findNavController().navigate(action)
        }

        passwortBestaetigenEditText.addTextChangedListener(object : TextWatcher{
            override fun equals(other: Any?): Boolean {
                return super.equals(other)
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            //Prüft, ob Eingaben getätigt wurden und ob Passwort übereinstimmt. Aktiviert dann den [registerButton]
            override fun afterTextChanged(s: Editable?) {
                val email = emailEditText.text.toString()
                val nutzername = nutzernameEditText.text.toString()
                val passwort_1 = passwortEingabeEditText.text.toString()
                val passwort_2 = passwortBestaetigenEditText.text.toString()

                //Passt E-Mail?
                if (email != "" && (email.contains("@"))){
                    Log.i(TAG, "E-Mail ok")
                    //Passt Nutzername?
                    if (nutzername != ""){
                        Log.i(TAG, "Nutzername ok")
                        //Passt Passwörter?
                        if (passwort_1 == passwort_2){
                            Log.i(TAG, "Passwörter ok")
                            enabledButton(registerButton)
                        }
                    } else {
                        Toast.makeText(activity,"Bitte fülle das Nutzernamen Feld aus.", Toast.LENGTH_SHORT).show()
                        registerButton.isEnabled = false
                    }
                } else {
                    Toast.makeText(activity,"Bitte fülle das E-Mail Feld aus.", Toast.LENGTH_SHORT).show()
                    registerButton.isEnabled = false
                }
            }
        })

    }

    fun signUP(){
        //Client
        val api = initRetro2()

        //Abgreifen der Eingaben
        val email = emailEditText.text.toString()
        val vorname = vornameEditText.text.toString()
        val nachname = nachnameEditText.text.toString()
        val nutzername = nutzernameEditText.text.toString()
        val passwort = passwortEingabeEditText.text.toString()
        val birthdate: String = "null"

        //Erstellen des Datenobjekts
        val data: SignUp = SignUp(vorname,nachname,email,passwort, nutzername, birthdate)

        api.setSignUp(data).enqueue(object : Callback<SignUpResponse> {
            override fun onResponse(
                call: Call<SignUpResponse>,
                response: Response<SignUpResponse>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        Log.i(TAG, "${it.msg}")
                        Toast.makeText(activity,"${it.msg}",Toast.LENGTH_SHORT).show()
                    }
                }
            }
            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                Log.e(TAG,"$t.message")
            }
        })
    }

    fun initRetro2(): RetrofitApi {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApi::class.java)
        return api
    }

    //Prüft ob der Button enabled ist oder nicht. Dadurch ändert sich der Zustand bzw. Farbe des Buttons
    fun enabledButton(button: Button){
        if(!button.isEnabled){
            button.isEnabled = true
        }
    }
}