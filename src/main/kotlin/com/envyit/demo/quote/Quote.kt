package com.envyit.demo.quote

import java.math.BigDecimal
import java.util.*

data class Quote(val id: UUID, val price: BigDecimal) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Quote

        if (id != other.id) return false
        if (price != other.price) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + price.hashCode()
        return result
    }


    override fun toString(): String {
        return "Quote(id=$id, price=$price)"
    }

}