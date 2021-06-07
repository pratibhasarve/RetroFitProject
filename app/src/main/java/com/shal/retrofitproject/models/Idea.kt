package com.shal.retrofitproject.models

data class Idea(
    val id: Int?,
    val name: String? = null,
    val description: String? = null,
    val status: String? = null,
    val owner: String? = null
) {

}
