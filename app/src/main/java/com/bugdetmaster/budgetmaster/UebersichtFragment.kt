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
    //Tag für die Konsole
    final val TAG = "BUDGETMASTER"

    private lateinit var progressBar: ProgressBar
    private lateinit var progressText: TextView
    private var percentage: Int = 0

    //Die URL des Servers
    val BASE_URL = "http://85.215.77.230/"

    companion object{
        lateinit var Api: Retrofit
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialisiere ProgressBar und TextView
        progressBar = view.findViewById(R.id.progress_bar)
        progressText = view.findViewById(R.id.progressbar_text)

        progress(13000,20000)
        getAccountDetails()
        //Den Zurückknopf für das aktuelle Fragment deaktivieren. Damit der User nicht mehr in den Login/SignUp Screen kommt.
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {}
        })


    }

    fun progress(balance : Int, savingsGoal: Int){
        val prozent = (balance.toDouble() / savingsGoal.toDouble()) * 100
        prozent.toInt()
        // Handler wird verwendet, um die ProgressBar mit einem animierten Fortschritt zu aktualisieren
        val handler = Handler()
        progressText.text = "$balance/$savingsGoal"
        // PostDelayed-Methode startet die Aktualisierung nach einer Verzögerung
        handler.postDelayed(object: Runnable{
            override fun run() {
                // Prüfe, ob der Fortschritt kleiner oder gleich 100 ist
                if (prozent>percentage) {
                    // aktualisiere die ProgressBar
                    progressBar.setProgress(percentage)
                    percentage++
                    // Wiederhole die Aktualisierung nach einer Verzögerung
                    handler.postDelayed(this, 200)
                } else {
                    // Entferne den Callback, wenn der Fortschritt 100 erreicht hat
                    handler.removeCallbacks(this)
                }
            }
        }, 200)
    }

    fun login(): RetrofitApi{
        //Client
        val api = initRetro2()

        val password = "1234"
        val username = "AndroidPass"
        //Erstellen des Datenobjekts
        val data: Login = Login(username, password)

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

    fun getAccountDetails(){
        //Client
        val api = login()

        api.getAccounts().enqueue(object : Callback<List<Account>>{

            override fun onResponse(
                call: Call<List<Account>>,
                response: Response<List<Account>>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        for(elements in it){
                            Log.i(TAG, "${elements.AccountId}")
                        }
                        Log.i(TAG, "AccountId ${it[0].AccountId}, AccountName ${it[0].AccountName}, Balance ${it[0].Balance},Currency: ${it[0].Currency},Username: ${it[0].Username},SavingsGoal: ${it[0].SavingsGoal}")
                        val balance = it[0].Balance/100
                        val savingsgoal = it[0].SavingsGoal/100
                    }
                }
            }

            override fun onFailure(call: Call<List<Account>>, t: Throwable) {
                Log.i(TAG, "${t.message}")
            }
        })
    }

    /**
     * Die Methode soll von einem User, hier noch Hardcoded, den aktuellen Stand des Attribut "Balance" bekommen.
     */
    fun getBalance(){
        //Client
        val api = initRetro2()

        val password = "1234"
        val username = "AndroidPass"
        //Erstellen des Datenobjekts
        val data: Login = Login(username, password)

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

        val balance: MutableList<Int> = mutableListOf(0)

        val data2: getBalance = com.bugdetmaster.budgetmaster.data.account.getBalance(16)
        api.setGetBalance(data2).enqueue(object : Callback<getBalanceResponse>{
            override fun onResponse(
                call: Call<getBalanceResponse>,
                response: Response<getBalanceResponse>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        Log.i(TAG, "${it.balance}")
                        balance[0] = it.balance
                    }
                }

            }

            override fun onFailure(call: Call<getBalanceResponse>, t: Throwable) {
               Log.e(TAG, "${t.message}")
            }
        })

        Log.i("LIST", "$balance")
    }

    /**
     * Die Methode gibt das Sparziel eines User zurück. Hier ist noch das der Account Hardcoded
     */
    fun getSavingsGoal(){
        val api = login()

        val data: getSavingsGoal = com.bugdetmaster.budgetmaster.data.account.getSavingsGoal(16)
        api.setGetSavingsGoal(data).enqueue(object: Callback<getSavingsGoalResponse>{
            override fun onResponse(
                call: Call<getSavingsGoalResponse>,
                response: Response<getSavingsGoalResponse>
            ) {
               if (response.isSuccessful){
                   response.body()?.let {
                       Log.i(TAG, "savings goal: ${response.body()?.savings_goal}")
                   }
               }

            }

            override fun onFailure(call: Call<getSavingsGoalResponse>, t: Throwable) {
                Log.e(TAG, "${t.message}")
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


}