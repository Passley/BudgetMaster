package com.bugdetmaster.budgetmaster.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitApi {

    @GET("getExampleData")
    fun getExampleData(): Call<List<ExampleData>>

    @GET("getAccounts")
    fun getAccounts(): Call<List<Account>>

    @POST("signUp")
    fun setSignUp(@Body call: SignUp): Call<SignUpResponse>
}