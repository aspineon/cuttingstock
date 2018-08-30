package com.nibado.example.cuttingstock.model

data class Configuration(val configuration: List<Pair<Product, RecipeItem>>) {
    fun price() = configuration.sumBy { it.first.price }
}
