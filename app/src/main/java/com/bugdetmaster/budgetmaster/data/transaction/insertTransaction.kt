package com.bugdetmaster.budgetmaster.data.transaction

import com.google.gson.annotations.SerializedName

data class insertTransaction(
    @SerializedName("category_id")
    val category_id: Int,
    @SerializedName("account_id")
    val account_id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("comment")
    val comment: String,
    @SerializedName("date")
    val date: String
)
