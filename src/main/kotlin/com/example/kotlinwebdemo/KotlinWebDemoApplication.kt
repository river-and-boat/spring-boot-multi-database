package com.example.kotlinwebdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinWebDemoApplication

fun main(args: Array<String>) {
    runApplication<KotlinWebDemoApplication>(*args)
}
