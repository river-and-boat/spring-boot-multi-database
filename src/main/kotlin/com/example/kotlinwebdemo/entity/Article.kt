package com.example.kotlinwebdemo.entity

import com.example.kotlinwebdemo.extension.toSlug
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Article {
    @ManyToOne(cascade = [CascadeType.PERSIST]) lateinit var author: User
    @Id
    @GeneratedValue
    var id: Long? = null
    var title: String = ""
    var headline: String = ""
    var content: String = ""
    var slug: String = title.toSlug()
    var addedAt: LocalDateTime = LocalDateTime.now()
}