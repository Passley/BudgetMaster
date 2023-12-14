package com.bugdetmaster.budgetmaster.data.account

import com.google.gson.annotations.SerializedName

data class updateAccountName(
    @SerializedName("account_id")
    val account_id: Int,
    @SerializedName("name")
    val name: String
)
