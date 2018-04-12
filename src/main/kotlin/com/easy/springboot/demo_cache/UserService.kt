package com.easy.springboot.demo_cache

interface UserService {
    fun findAll(): List<User>
    fun saveUser(u: User): User
    fun updatePassword(id:Long, password: String): Int
    fun findOne(id: Long): User
}