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
    //Tag für die Konsole
    final val TAG = "BUDGETMASTER"

    //Die URL des Servers
    val BASE_URL = "http://85.215.77.230/"

    /**
     * Ermöglicht dem Code, dass Methoden in der Klasse aufgerufen werden können, ohne das eine Instanz erstellt wurde.
     * Ähnelt der Static Methode aus Java.
     */
    companion object{
        lateinit var Api: Retrofit
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.BTN_TEST).setOnClickListener {
            val action=AusgabenFragmentDirections.actionAusgabenFragmentToAusgabeErstellenFragment()
            findNavController().navigate(action)
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {}
        })


        /**
         * Mit der kommenden Methode wird der Button "Hinzufügen" mit der ID addAusgabeButton angesprochen.
         * Dieser hat mit dem setClickListener-Methode die Aufgabe, den Benutzer auf das Fragment AusgabeErstellenFragment zu verweisen.
         * Der Navigationsgraph kennt alle möglichen Routen und die action Variable erstellt die Route vom aktuellen Fragment zum AusgabeErstellenFragment.
         * Die findNavController Klasse führt dann die Route aus.
         */

        //Den Zurückknopf für das aktuelle Fragment deaktivieren. Damit der User nicht mehr in den Login/SignUp Screen kommt.
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {}
        })
    }

    fun readTransaction(){
        val api = login()


        val data2: readTransaction = com.bugdetmaster.budgetmaster.data.transaction.readTransaction(48)

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

    fun login(): RetrofitApi {
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

    fun initRetro2(): RetrofitApi {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApi::class.java)
        return api
    }
}