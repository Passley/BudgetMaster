package com.bugdetmaster.budgetmaster.data.transaction

import com.google.gson.annotations.SerializedName

data class insertTransactionResponse(
    @SerializedName("msg")
    val msg: String
)
