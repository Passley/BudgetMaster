package com.bugdetmaster.budgetmaster

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.bugdetmaster.budgetmaster.data.RetrofitApi
import com.bugdetmaster.budgetmaster.data.login.Login
import com.bugdetmaster.budgetmaster.data.login.LoginResponse
import com.bugdetmaster.budgetmaster.data.transaction.readTransaction
import com.bugdetmaster.budgetmaster.data.transaction.readTransactionResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class AusgabenFragment : Fragment(R.layout.fragment_ausgaben) {

    // Tag für die Verwendung in der Konsole
    final val TAG = "BUDGETMASTER"

    // Die Basis-URL des Servers
    val BASE_URL = "http://85.215.77.230/"

    /**
     * Companion-Objekt, das es ermöglicht, Methoden in der Klasse aufzurufen,
     * ohne eine Instanz erstellen zu müssen. Ähnlich einer Static-Methode in Java.
     */
    companion object{
        lateinit var Api: Retrofit
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Klick-Ereignis für den Test-Button, um zum Fragment AusgabeErstellenFragment zu navigieren
        view.findViewById<Button>(R.id.BTN_TEST).setOnClickListener {
            val action = AusgabenFragmentDirections.actionAusgabenFragmentToAusgabeErstellenFragment()
            findNavController().navigate(action)
        }

        // Den Zurückknopf für das aktuelle Fragment deaktivieren, um den Benutzer im aktuellen Flow zu halten
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {}
        })

        // Methode, um eine Transaktion zu lesen
        readTransaction()
    }

    // Methode, um eine Transaktion zu lesen
    fun readTransaction(){
        val api = login() // API-Instanz erstellen

        val data2: readTransaction = com.bugdetmaster.budgetmaster.data.transaction.readTransaction(48)

        // API-Anfrage, um Transaktionen abzurufen
        api.ReadTransaction(data2).enqueue(object : Callback<readTransactionResponse>{
            override fun onResponse(
                call: Call<readTransactionResponse>,
                response: Response<readTransactionResponse>
            ) {
                if (response.isSuccessful){
                    response.body()?.let {
                        Log.i(TAG, "${it.amount}, ${it.transaction_id}, ${it.name}")
                    }
                }
            }

            override fun onFailure(call: Call<readTransactionResponse>, t: Throwable) {
                Log.e(TAG, "${t.message}")
            }
        })
    }

    // Methode, um sich am Server anzumelden
    fun login(): RetrofitApi {
        // Retrofit API-Instanz initialisieren
        val api = initRetro2()

        val password = "1234"
        val username = "AndroidPass"
        val data: Login = Login(username, password) // Login-Daten erstellen

        // API-Anfrage für die Anmeldung
        api.setLogin(data).enqueue(object : Callback<LoginResponse> {

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful){
                    Log.i(TAG, "Erfolgreich angemeldet...")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e(TAG, "Response Login: ${t.message}")
            }
        })
        return api
    }

    // Methode, um eine Retrofit API-Instanz zu initialisieren
    fun initRetro2(): RetrofitApi {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApi::class.java)
        return api
    }
}

}