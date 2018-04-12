package com.easy.springboot.demo_cache

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    @Autowired lateinit var userService: UserService

    @GetMapping("/user/list")
    fun findAll(): List<User> {
        return userService.findAll()
    }

    @GetMapping("/user/save")
    fun save(user: User): User {
        return userService.saveUser(user)
    }

    @GetMapping("/user/updatePassword")
    fun updatePassword(id: Long, password: String): Int {
        return userService.updatePassword(id, password)
    }

    @GetMapping("/user/{id}")
    fun findOne(@PathVariable("id") id: Long): User {
        return userService.findOne(id)
    }

}