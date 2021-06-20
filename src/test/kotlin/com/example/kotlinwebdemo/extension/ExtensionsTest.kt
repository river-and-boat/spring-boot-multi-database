package com.example.kotlinwebdemo.extension

import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class ExtensionsTest {
    @Test
    fun `should return english format time`() {
        val now = LocalDateTime.now()
        val time = now.formatEnglish()
        println(time)
    }

    @Test
    fun `should return format string`() {
        val name = "Hello World!*he\\+ss-~oo!ll@?.world"
        println(name.toSlug())
    }
}