package com.bugdetmaster.budgetmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bugdetmaster.budgetmaster.databinding.ActivityMainBinding
import com.bugdetmaster.budgetmaster.databinding.FragmentLoginBinding
import com.bugdetmaster.budgetmaster.databinding.FragmentRegisterBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var bindingLoginFragment: FragmentLoginBinding

    private lateinit var bindingRegisterFragment: FragmentRegisterBinding

    /** Jetzt kommen die Button/EditTexts für Login/RegisterScreen
     *
     */

    /**
     * RegisterScreen
     */
    private lateinit var btnRegister: Button

    private lateinit var btnAbbrechen: Button

    private lateinit var btnScreenzuSwitchLogin: TextView

    private lateinit var EditText_Register_Eingabe_Password: EditText

    private lateinit var EditText_Register_Eingabe_Password_bestaetigen: EditText

    private lateinit var EditText_Register_Eingabe_Email: EditText

    private lateinit var EditText_Register_Eingabe_Nutzername: EditText



    /**
     * LoginScreen
     */

    private lateinit var btnLoginAnmelden: Button

    private lateinit var GoogleBtnAnmelden: Button

    private lateinit var btnScreenzuSwitchRegister: TextView

    private lateinit var EditText_Login_Eingabe_Password: EditText

    private lateinit var EditText_Login_Eingabe_Email: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        //Für LOGIN Vorschau
        setContentView(binding.root)
        replaceFragment(LoginFragment())
        binding.bottomNavigationView.visibility = View.GONE
        binding.topAppBar.visibility = View.GONE


        //Für Menüvorschau
        //setContentView(binding.root)
        //replaceFragment(UebersichtFragment())


        /** GoogleBtnAnmelden = findViewById(R.id.sign_in_button)
        btnScreenzuSwitchRegister = findViewById(R.id.Text_Registrieren)
        EditText_Login_Eingabe_Password = findViewById(R.id.Eingabe_Password)
        EditText_Login_Eingabe_Password = findViewById(R.id.Eingabe_Email)
        EditText_Login_Eingabe_Email = findViewById(R.id.Eingabe_Email)*/

        /**Bottombar Navigation
         *
         * Hier wird das Layout des Fragment abhängig vom Klick ausgewählt und aufgerufen
         *
         */
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.page_1 -> replaceFragment(UebersichtFragment())
                R.id.page_2 -> replaceFragment(AusgabenFragment())
                R.id.page_3 -> replaceFragment(SparplanFragment())
                R.id.page_4 -> replaceFragment(SettingsOneFragment())

                else ->{
                    Log.i("BottomNavigation", "Nothing selected")
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()

    }



}