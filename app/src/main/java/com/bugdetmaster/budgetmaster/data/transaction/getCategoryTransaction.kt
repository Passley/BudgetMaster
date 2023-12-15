package com.bugdetmaster.budgetmaster.data.transaction

import com.google.gson.annotations.SerializedName

data class getCategoryTransaction(
    @SerializedName("account_id")
    val account_id: Int,
    @SerializedName("category_id")
    val category_id: Int
)
