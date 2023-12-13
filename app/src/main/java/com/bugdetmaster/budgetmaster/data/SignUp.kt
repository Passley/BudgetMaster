package com.bugdetmaster.budgetmaster.data

import com.google.gson.annotations.SerializedName

data class SignUp(@SerializedName("first_name")
                  val first_name: String,
                  @SerializedName("last_name")
                  val last_name: String,
                  @SerializedName("email")
                  val email: String,
                  @SerializedName("password")
                  val password: String,
                  @SerializedName("username")
                  val username: String,
                  @SerializedName("birthdate")
                  val birthdate: String)
