package com.nibado.example.cuttingstock.model

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

class ProductList(val products: List<Product>) {
    companion object {
        fun load() : ProductList = ObjectMapper()
                .registerKotlinModule()
                .readValue(ProductList::class.java.getResourceAsStream("/products.json"))
    }
}
