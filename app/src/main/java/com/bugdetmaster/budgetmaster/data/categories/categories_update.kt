package com.bugdetmaster.budgetmaster.data.categories

import com.google.gson.annotations.SerializedName

data class categories_update(
    @SerializedName("name")
    val name: String,
    @SerializedName("category_id")
    val category_id: Int
)
