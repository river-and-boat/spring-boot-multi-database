package com.example.kotlinwebdemo.repository

import com.example.kotlinwebdemo.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(login: String): User?
}