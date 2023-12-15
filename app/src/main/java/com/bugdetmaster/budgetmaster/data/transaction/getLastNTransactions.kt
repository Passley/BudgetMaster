package com.bugdetmaster.budgetmaster.data.transaction

import com.google.gson.annotations.SerializedName

data class getLastNTransactions(
    @SerializedName("account_id")
    val account_id: Int,
    @SerializedName("N")
    val N: Int
)
