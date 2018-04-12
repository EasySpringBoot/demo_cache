package com.easy.springboot.demo_cache

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserDao : JpaRepository<User, Long> {
    @Query("update #{#entityName} a set a.password = :password where a.id=:id")
    @Modifying
    fun updatePassword(@Param("id") id: Long, @Param("password") password: String): Int
}