package com.bugdetmaster.budgetmaster.data.transaction

import com.google.gson.annotations.SerializedName

data class deleteTransactionResponse(
    @SerializedName("msg")
    val msg: String
)
