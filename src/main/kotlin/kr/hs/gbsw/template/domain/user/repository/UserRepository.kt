package kr.hs.gbsw.template.domain.user.repository

import org.apache.catalina.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository: JpaRepository<User, Long> {

    fun findByEmail(email: String): Optional<User>
}