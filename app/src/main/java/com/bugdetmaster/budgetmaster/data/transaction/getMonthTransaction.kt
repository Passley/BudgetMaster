package com.bugdetmaster.budgetmaster.data.transaction

import com.google.gson.annotations.SerializedName

data class getMonthTransaction(
    @SerializedName("account_id")
    val account_id: Int,
    @SerializedName("month")
    val month: Int
)
