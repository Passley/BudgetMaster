package com.bugdetmaster.budgetmaster.data

data class Account(
    val AccountId: Int,
    val AccountName: String,
    val Balance: Int,
    val Currency: String,
    val Username: String,
    val SavingsGoal: String
)
