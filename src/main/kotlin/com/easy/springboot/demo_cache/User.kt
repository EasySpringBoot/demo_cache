package com.easy.springboot.demo_cache

import javax.persistence.*

@Entity
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(unique = true, length = 100)
    var username: String = ""
    @Column(length = 100)
    var password: String = ""

}