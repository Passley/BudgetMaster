package com.bugdetmaster.budgetmaster.data

import com.bugdetmaster.budgetmaster.data.account.createAccount
import com.bugdetmaster.budgetmaster.data.account.createAccountResponse
import com.bugdetmaster.budgetmaster.data.account.deleteAccount
import com.bugdetmaster.budgetmaster.data.account.deleteAccountResponse
import com.bugdetmaster.budgetmaster.data.account.getBalance
import com.bugdetmaster.budgetmaster.data.account.getBalanceResponse
import com.bugdetmaster.budgetmaster.data.account.getSavingsGoal
import com.bugdetmaster.budgetmaster.data.account.getSavingsGoalResponse
import com.bugdetmaster.budgetmaster.data.account.updateAccountName
import com.bugdetmaster.budgetmaster.data.account.updateAccountNameResponse
import com.bugdetmaster.budgetmaster.data.account.updateSavingsGoal
import com.bugdetmaster.budgetmaster.data.account.updateSavingsGoalResponse
import com.bugdetmaster.budgetmaster.data.categories.categories_create
import com.bugdetmaster.budgetmaster.data.categories.categories_createResponse
import com.bugdetmaster.budgetmaster.data.categories.categories_delete
import com.bugdetmaster.budgetmaster.data.categories.categories_deleteResponse
import com.bugdetmaster.budgetmaster.data.categories.categories_update
import com.bugdetmaster.budgetmaster.data.categories.categories_updateResponse
import com.bugdetmaster.budgetmaster.data.login.Login
import com.bugdetmaster.budgetmaster.data.login.LoginResponse
import com.bugdetmaster.budgetmaster.data.login.LogoutResponse
import com.bugdetmaster.budgetmaster.data.login.SignUp
import com.bugdetmaster.budgetmaster.data.login.SignUpResponse
import com.bugdetmaster.budgetmaster.data.login.checkedLoggedInResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitApi {

    @GET("getExampleData")
    fun getExampleData(): Call<List<ExampleData>>

    //Alle für Login
    @POST("signUp")
    fun setSignUp(@Body call: SignUp): Call<SignUpResponse>

    @POST("login")
    fun setLogin(@Body call: Login): Call<LoginResponse>

    @GET("checkedLoggedIn")
    fun getCheckedLoggedIn(): Call<checkedLoggedInResponse>

    @GET("logout")
    fun getLogout(): Call<LogoutResponse>

    //Alle für Account

    @GET("getAccounts")
    fun getAccounts(): Call<List<Account>>

    @POST("createAccount")
    fun setCreateAccount(@Body call: createAccount): Call<createAccountResponse>

    @POST("updateAccountName")
    fun updateAccountName(@Body call: updateAccountName): Call<updateAccountNameResponse>

    @POST("deleteAccount")
    fun setDeleteAccount(@Body call: deleteAccount): Call<deleteAccountResponse>

    @POST("updateSavingsGoal")
    fun updateSavingsGoal(@Body call: updateSavingsGoal): Call<updateSavingsGoalResponse>

    @POST("getSavingsGoal")
    fun setGetSavingsGoal(@Body call: getSavingsGoal): Call<getSavingsGoalResponse>

    @POST("getBalance")
    fun setGetBalance(@Body call: getBalance): Call<getBalanceResponse>

    //Alle für Transaktionen




    //Alle für Kategorien
    //toDO: GET categories erstellen

    @POST("categories/create")
    fun setCategories_create(@Body call: categories_create): Call<categories_createResponse>

    @POST("categories/update")
    fun setCategories_update(@Body call: categories_update): Call<categories_updateResponse>

    @POST("categories/delete")
    fun setCategories_delete(@Body call: categories_delete): Call<categories_deleteResponse>

}