package com.bugdetmaster.budgetmaster

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.bugdetmaster.budgetmaster.data.Account
import com.bugdetmaster.budgetmaster.data.RetrofitApi
import com.bugdetmaster.budgetmaster.data.account.getBalance
import com.bugdetmaster.budgetmaster.data.account.getBalanceResponse
import com.bugdetmaster.budgetmaster.data.account.getSavingsGoal
import com.bugdetmaster.budgetmaster.data.account.getSavingsGoalResponse
import com.bugdetmaster.budgetmaster.data.login.Login
import com.bugdetmaster.budgetmaster.data.login.LoginResponse
import com.bugdetmaster.budgetmaster.data.login.LogoutResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log


class UebersichtFragment : Fragment(R.layout.fragment_uebersicht) {

    // Tag für die Verwendung in der Konsole
    final val TAG = "BUDGETMASTER"

    private lateinit var progressBar: ProgressBar
    private lateinit var progressText: TextView
    private var percentage: Int = 0

    // Die URL des Servers
    val BASE_URL = "http://85.215.77.230/"

    companion object{
        lateinit var Api: Retrofit
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialisiere ProgressBar und TextView
        progressBar = view.findViewById(R.id.progress_bar)
        progressText = view.findViewById(R.id.progressbar_text)

        // Starte den Fortschrittsbalken für die Anzeige von Sparfortschritt
        progress(12150,18000)

        // Rufe die Kontodetails ab
        getAccountDetails()

        // Deaktiviere den Zurückknopf für das aktuelle Fragment, um den Benutzer im Flow zu halten
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {}
        })
    }

    // Methode zur Aktualisierung der Fortschrittsanzeige
    fun progress(balance : Int, savingsGoal: Int){
        val prozent = (balance.toDouble() / savingsGoal.toDouble()) * 100
        prozent.toInt()
        // Verwende Handler für eine animierte ProgressBar-Aktualisierung
        val handler = Handler()
        progressText.text = "$balance/$savingsGoal"
        // PostDelayed-Methode startet die Aktualisierung nach einer Verzögerung
        handler.postDelayed(object: Runnable{
            override fun run() {
                if (prozent > percentage) {
                    progressBar.setProgress(percentage)
                    percentage++
                    handler.postDelayed(this, 200)
                } else {
                    handler.removeCallbacks(this)
                }
            }
        }, 200)
    }

    // Methode zur Anmeldung beim Server
    fun login(): RetrofitApi{
        val api = initRetro2()

        val password = "1234"
        val username = "AndroidPass"
        val data: Login = Login(username, password)

        api.setLogin(data).enqueue(object : Callback<LoginResponse> {
            // ...
        })
        return api
    }

    // Methode zum Abrufen von Kontodetails
    fun getAccountDetails(){
        val api = login()

        api.getAccounts().enqueue(object : Callback<List<Account>>{
            // ...
        })
    }

    // Methode zum Abrufen des aktuellen Kontostands eines Benutzers
    fun getBalance(){
        val api = initRetro2()

        val password = "1234"
        val username = "AndroidPass"
        val data: Login = Login(username, password)

        // ...
    }

    // Methode zum Abrufen des Sparziels eines Benutzers
    fun getSavingsGoal(){
        val api = login()

        // ...
    }

    // Methode zur Initialisierung einer Retrofit API-Instanz
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