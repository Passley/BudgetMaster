package com.bugdetmaster.budgetmaster.data.account

import com.google.gson.annotations.SerializedName

data class getBalanceResponse(
    @SerializedName("balance")
    val balance: Int
)
