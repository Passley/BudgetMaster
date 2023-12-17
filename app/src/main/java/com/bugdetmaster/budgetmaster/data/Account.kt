package com.bugdetmaster.budgetmaster.data

import com.google.gson.annotations.SerializedName

data class Account(
    @SerializedName("AccountId")
    val AccountId: Int,
    @SerializedName("AccountName")
    val AccountName: String,
    @SerializedName("Balance")
    val Balance: Int,
    @SerializedName("Currency")
    val Currency: String,
    @SerializedName("Username")
    val Username: String,
    @SerializedName("SavingsGoal")
    val SavingsGoal: Int
)
