package com.bugdetmaster.budgetmaster.data.account

import com.google.gson.annotations.SerializedName

data class getBalance(
    @SerializedName("account_id")
    val account_id: Int
)
