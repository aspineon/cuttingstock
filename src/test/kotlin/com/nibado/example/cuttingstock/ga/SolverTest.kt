package com.nibado.example.cuttingstock.ga

import com.nibado.example.cuttingstock.model.Recipe
import com.nibado.example.cuttingstock.model.RecipeItem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class SolverTest {

    @Test
    fun solve() {
        val recipe = Recipe(listOf(
            RecipeItem(500, 18, 600, 3),
            RecipeItem(1000, 18, 500, 2),
            RecipeItem(250, 18, 600, 1)
        ))

        val solution = Solver.solve(recipe)

        assertThat(solution.configuration).hasSize(6)
    }

    @Test
    fun solveInvalidRecipe() {
        fun assertInvalid(item: RecipeItem) {
            val exception : IllegalArgumentException = assertThrows { Solver.solve(Recipe(listOf(item))) }
            assertThat(exception.message).contains("items can't be mapped to products")
        }

        assertInvalid(RecipeItem(500, 18, 123, 3))
        assertInvalid(RecipeItem(500, 17, 600, 3))
        assertInvalid(RecipeItem(50000, 18, 600, 3))
    }
}

