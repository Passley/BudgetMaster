package com.bugdetmaster.budgetmaster

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.bugdetmaster.budgetmaster.data.RetrofitApi
import com.bugdetmaster.budgetmaster.data.login.Login
import com.bugdetmaster.budgetmaster.data.login.LoginResponse
import com.bugdetmaster.budgetmaster.data.login.LogoutResponse
import com.bugdetmaster.budgetmaster.data.login.checkedLoggedInResponse
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SettingsTwoFragment : Fragment(R.layout.fragment_settings_two) {
    // Tag für die Konsole
    final val TAG = "BUDGETMASTER"

    // Die URL des Servers
    val BASE_URL = "http://85.215.77.230/"

    companion object {
        lateinit var Api: Retrofit
    }

    // Stellt den Zurück-Button nach
    lateinit var zurückButton: Button
    // Stellt den Abmelden-Button nach
    lateinit var abmeldenButton: Button
    // Stellt den Konto Löschen-Button nach
    lateinit var kontoloeschenButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Verstecke die Navigationsleiste, wenn dieses Fragment angezeigt wird
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.GONE

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Verbindet Variablen mit Objekten im Layout
        zurückButton = view.findViewById(R.id.sett_abbrechen)
        abmeldenButton = view.findViewById(R.id.btn_settings2_Abmelden)
        kontoloeschenButton = view.findViewById(R.id.btn_settings2_Kon_loeschen)

        abmeldenButton.setOnClickListener {
            loginToLogOut()
            val action = SettingsTwoFragmentDirections.actionSettingsTwoFragmentToLoginFragment()
            findNavController().navigate(action)
        }

        kontoloeschenButton.setOnClickListener {
            val action = SettingsTwoFragmentDirections.actionSettingsTwoFragmentToKontoLoeschen()
            findNavController().navigate(action)
        }

        zurückButton.setOnClickListener {
            // Zeige die Navigationsleiste wieder an
            activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.VISIBLE

            // Zeige die ActionBar wieder an
            (requireActivity() as? AppCompatActivity)?.supportActionBar?.show()

            // Zeige die Top-Bar wieder an
            (requireActivity().findViewById(R.id.topAppBar) as? MaterialToolbar)?.visibility = View.VISIBLE

            // Navigiere zum vorherigen Fragment
            val action = SettingsTwoFragmentDirections.actionSettingsTwoFragmentToSettingsOneFragment()
            findNavController().navigate(action)
        }
    }

    // Funktion für die Anmeldung des Benutzers
    fun login(): RetrofitApi {
        // Client-Initialisierung
        val api = initRetro2()

        val password = "AndroidPass"
        val username = "1234"
        // Erstellen des Datenobjekts für die Anmeldung
        val data: Login = Login(username, password)

        api.setLogin(data).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    Log.i(TAG, "Erfolgreich angemeldet...")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e(TAG, "Response Login: ${t.message}")
            }
        })
        return api
    }

    // Funktion für die Abmeldung des Benutzers
    fun loginToLogOut() {
        val api = login()
        api.getLogout().enqueue(object : Callback<LogoutResponse> {
            override fun onResponse(call: Call<LogoutResponse>, response: Response<LogoutResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        Toast.makeText(activity, "${it.msg}", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<LogoutResponse>, t: Throwable) {
                Log.i(TAG, "${t.message}")
            }
        })
    }

    // Funktion für die Überprüfung des Benutzer-Logins
    fun checkedLogin() {
        val api = initRetro2()

        api.getCheckedLoggedIn().enqueue(object : Callback<checkedLoggedInResponse> {
            override fun onResponse(
                call: Call<checkedLoggedInResponse>,
                response: Response<checkedLoggedInResponse>
            ) {
                if (response.isSuccessful) {

                    response.body()?.let {
                        Toast.makeText(activity, "${it.IsLoggedIn}", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<checkedLoggedInResponse>, t: Throwable) {
                Log.e(TAG, "FEHLSCHLAG CHECKEDLOGIN: FALSE")
                Log.e(TAG, "${t.message}")
            }
        })
    }

    /**
     * Initialisiert den Retrofit Client und fügt die URL und den JSON Konverter hinzu
     */
    fun initRetro2(): RetrofitApi {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApi::class.java)
        return api
    }
}
