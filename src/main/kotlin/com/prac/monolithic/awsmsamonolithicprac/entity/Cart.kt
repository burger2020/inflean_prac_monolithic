package com.prac.monolithic.awsmsamonolithicprac.entity

import jakarta.persistence.*

@Entity
@Table(name = "carts")
class Cart(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToMany
    val items: List<CartItem> = listOf()
)