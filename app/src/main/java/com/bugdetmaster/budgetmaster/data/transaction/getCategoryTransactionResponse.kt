package com.bugdetmaster.budgetmaster.data.transaction

import com.google.gson.annotations.SerializedName

data class getCategoryTransactionResponse (
    @SerializedName("transaction_id")
    val transaction_id: Int,
    @SerializedName("category_id")
    val category_id: Int,
    @SerializedName("account_id")
    val account_id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("amount")
    val amount: String,
    @SerializedName("dare")
    val dare: String
)