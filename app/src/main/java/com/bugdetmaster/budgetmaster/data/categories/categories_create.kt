package com.bugdetmaster.budgetmaster.data.categories

import com.google.gson.annotations.SerializedName

data class categories_create(
    @SerializedName("name")
    val name: String,
    @SerializedName("account_id")
    val account_id: Int
)
