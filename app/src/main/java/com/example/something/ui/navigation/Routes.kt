package com.example.something.ui.navigation

sealed class Routes(val route: String, vararg params: String) {
    val withParams: String = if (params.isNotEmpty()) {
        this.route + params.joinToString { "/{$it}" }
    } else this.route

    fun fillParams(vararg params: Any): String {
        return if (params.isNotEmpty()) {
            this.route + params.joinToString { "/$it" }
        } else this.route
    }

    object Welcome : Routes("Welcome")
    object Home : Routes("Home")
    object Notes : Routes("Notes")
}