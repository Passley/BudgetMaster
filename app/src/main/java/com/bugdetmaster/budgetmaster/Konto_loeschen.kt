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
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.bugdetmaster.budgetmaster.data.RetrofitApi
import com.bugdetmaster.budgetmaster.data.login.Login
import com.bugdetmaster.budgetmaster.data.login.LoginResponse
import com.bugdetmaster.budgetmaster.data.login.LogoutResponse
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Konto_loeschen : Fragment(R.layout.fragment_konto_loeschen) {
    lateinit var kontoLoeschenButton: Button


    //Die URL des Servers
    val BASE_URL = "http://85.215.77.230/"

    //Tag für die Konsole
    final val TAG = "BUDGETMASTER"
    companion object{
        lateinit var Api: Retrofit
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Verbindet Variable mit Button
        kontoLoeschenButton = view.findViewById(R.id.btn_kontoloesch_bestaetigen)

        /**
         * Mit der kommenden Methode wird der Button "Bestätigen" mit der ID btn_kontoloesch_bestaetigen angesprochen.
         * Dieser hat mit dem setClickListener-Methode die Aufgabe, den Benutzer auf das Fragment LoginFragment zu verweisen.
         * Der Navigationsgraph kennt alle möglichen Routen und die action Variable erstellt die Route vom aktuellen Fragment zum LoginFragment.
         * Die findNavController Klasse führt dann die Route aus.
         */
        kontoLoeschenButton.setOnClickListener {
            loginToLogOut()
            val action = Konto_loeschenDirections.actionKontoLoeschenToLoginFragment()
            findNavController().navigate(action)
        }

        //Den Zurückknopf für das aktuelle Fragment deaktivieren. Damit der User nicht mehr in den Login/SignUp Screen kommt.
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {}
        })
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Verstecke die Navigationsleiste, wenn dieses Fragment angezeigt wird
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.GONE
        return inflater.inflate(R.layout.fragment_konto_loeschen, container, false)
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

    /**
     * Die Methode logt den User ein und Loggt im weiteren Verlauf den User aus. Die Bestätigung vom Server
     * wird als TOAST an den User übergeben.
     */
    fun loginToLogOut(){
        //Client
        val api = initRetro2()

        val password = "AndroidPass"
        val username = "1234"
        //Erstellen des Datenobjekts
        val data: Login = Login(username, password)

        api.setLogin(data).enqueue(object : Callback<LoginResponse>{

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful){
                    Log.i(TAG, "Erfolgreich angemeldet...")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e(TAG, "Response Login: ${t.message}")
            }
        })
        api.getLogout().enqueue(object: Callback<LogoutResponse>{
            override fun onResponse(
                call: Call<LogoutResponse>,
                response: Response<LogoutResponse>
            ) {
                if (response.isSuccessful){
                    response.body()?.let {
                        Toast.makeText(activity, "${it.msg}", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<LogoutResponse>, t: Throwable) {
                Log.i(TAG,"${t.message}")
            }
        })
    }

    /**
     * Aktuell wird sich anhand des bestehenden Kontos eingeloggt und eine Session erstellt.
     * Da die Methode zeitlich nicht mehr implementiert werden konnte, wird einfach ein Logout
     *  durchgeführt.
     */
    fun deleteAcc(api: RetrofitApi){
        //toDo: needs to get Implemented. First needs delete Function from Backend
        //Replaced with LoginToLogut Method.
    }

}