package com.nibado.example.cuttingstock.ga

import com.nibado.example.cuttingstock.model.*

object Solver {
    private val products: List<Product> by lazy { ProductList.load().products }

    fun solve(recipe: Recipe) : Configuration {
        val invalidItems = invalidItems(recipe)

        if(invalidItems.isNotEmpty()) {
            throw IllegalArgumentException("${invalidItems.size} items can't be mapped to products: $invalidItems")
        }

        val list = toSingles(recipe.items)
                .map { products(it).first() to it }
                .map { it.first!! to it.second }

        return Configuration(list)
    }

    private fun toSingles(items: List<RecipeItem>) = items.flatMap { item -> (1 .. item.qtty).map { RecipeItem(item.length, item.height, item.width, 1) } }

    private fun invalidItems(recipe: Recipe) = recipe.items.map { it to products(it) }.filter { it.second.isEmpty() }.map { it.first }

    private fun products(item: RecipeItem) = products.filter { product -> product.height == item.height && product.width == item.width && product.length >= item.length }
}
