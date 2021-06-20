package com.example.kotlinwebdemo.repository

import com.example.kotlinwebdemo.entity.Article
import com.example.kotlinwebdemo.entity.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.ActiveProfiles

@DataJpaTest
@ActiveProfiles("test")
internal class RepositoryTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserRepository,
    val articleRepository: ArticleRepository
) {
    @Test
    fun `when findByIdOrNull then return article`() {
        // given
        val juergen = User()
        juergen.login = "springjuergen"
        juergen.firstname = "Juergen"
        juergen.lastname = "Hoeller"
        val article = Article()
        article.title = "Spring Framework 5.0 goes GA"
        article.headline = "Dear Spring community ..."
        article.content = "Lorem ipsum"
        article.author = juergen

        entityManager.persist(article)
        entityManager.flush()

        // when
        val actual = articleRepository.findByIdOrNull(article.id!!)

        // then
        assertThat(actual).isEqualTo(article)
    }

    @Test
    fun `when findUserByLogin then return user`() {
        // given
        val juergen = User()
        juergen.login = "springjuergen"
        juergen.firstname = "Juergen"
        juergen.lastname = "Hoeller"
        entityManager.persist(juergen)
        entityManager.flush()

        // when
        val actual = userRepository.findByLogin(juergen.login)

        // then
        assertThat(actual).isEqualTo(juergen)
    }
}