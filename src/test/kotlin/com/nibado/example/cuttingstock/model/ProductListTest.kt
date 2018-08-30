package com.nibado.example.cuttingstock.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProductListTest {
    @Test
    fun load() {
        val products = ProductList.load().products

        assertThat(products).hasSize(36)
    }
}
