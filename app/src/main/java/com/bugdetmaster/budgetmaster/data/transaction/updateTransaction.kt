package com.bugdetmaster.budgetmaster.data.transaction

import com.google.gson.annotations.SerializedName

data class updateTransaction(
    @SerializedName("transaction_id")
    val transaction_id: Int,
    @SerializedName("attribute")
    val attribute: String,
    @SerializedName("value")
    val value: Int
)
