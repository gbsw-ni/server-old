package codes.dya.drive.domain.user.entity

import jakarta.persistence.*
import kr.hs.gbsw.template.domain.user.dto.UserDto

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(unique = true)
        var email: String,

        var name: String,
        var password: String,
        var image: String
) {
    constructor(userDto: UserDto.Request, image: String): this (
            email = userDto.email,
            name = userDto.name,
            password = userDto.password,
            image = image
    )
}