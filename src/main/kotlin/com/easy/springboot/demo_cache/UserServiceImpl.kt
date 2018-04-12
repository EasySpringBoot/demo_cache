package com.easy.springboot.demo_cache

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class UserServiceImpl : UserService {


@Autowired lateinit var userDao: UserDao

@Cacheable("userList") // 标识读缓存操作
override fun findAll(): List<User> {
    return userDao.findAll()
}

@Transactional
@CachePut(cacheNames = ["user"], key = "#user.id")// 写入缓存，key 为 user.id ； 一般可以标注在save方法上面
override fun saveUser(user: User): User {
    return userDao.save(user)
}

@Transactional
@CacheEvict(cacheNames = ["user"], key = "#id")// 根据 key (值为id) 来清除缓存 ； 一般标注在delete,update方法上面
override fun updatePassword(id: Long, password: String): Int {
    return userDao.updatePassword(id, password)
}

@Cacheable(cacheNames = ["user"], key = "#id") // 如果缓存存在，直接读取缓存值； 如果不存在调用目标方法，并将方法返回结果放入缓存
override fun findOne(id: Long): User {
    return userDao.getOne(id)
}

}