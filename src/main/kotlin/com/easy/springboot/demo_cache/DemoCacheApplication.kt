package com.easy.springboot.demo_cache

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.support.BeanDefinitionDsl
import org.springframework.context.support.beans

@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration(exclude = [ErrorMvcAutoConfiguration::class])
open class DemoCacheApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder().initializers(
            beans {
                bean {
                    ApplicationRunner {
                        initUser()
                    }
                }
            }
    ).sources(DemoCacheApplication::class.java).run(*args)
}


/**
 * 初始化数据库用户表数据
 */
private fun BeanDefinitionDsl.BeanDefinitionContext.initUser() {
    val userDao = ref<UserDao>()
    try {
        val user = User()
        user.username = "user"
        user.password = "user"
        userDao.save(user)

        val jack = User()
        jack.username = "jack"
        jack.password = "123456"
        userDao.save(jack)

        val admin = User()
        admin.username = "admin"
        admin.password = "admin"
        userDao.save(admin)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
