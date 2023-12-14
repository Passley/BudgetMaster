package com.bugdetmaster.budgetmaster.data.account

import com.google.gson.annotations.SerializedName

data class createAccount(
    @SerializedName("currency")
    val currency: String,
    @SerializedName("name")
    val name: String)
