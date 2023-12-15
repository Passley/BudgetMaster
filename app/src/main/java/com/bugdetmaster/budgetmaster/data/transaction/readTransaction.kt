package com.bugdetmaster.budgetmaster.data.transaction

import com.google.gson.annotations.SerializedName

data class readTransaction(
    @SerializedName("transaction_id")
    val transaction_id: Int
)
