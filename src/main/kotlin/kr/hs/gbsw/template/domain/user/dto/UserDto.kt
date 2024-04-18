package kr.hs.gbsw.template.domain.user.dto

import codes.dya.drive.domain.user.entity.User
import org.springframework.web.multipart.MultipartFile

class UserDto {
    data class Login(
            var email: String,
            var password: String
    )

    data class Request(
            var email: String,
            var name: String,
            var password: String,
            var image: MultipartFile
    )

    data class Response(
            var id: Long?,
            var email: String,
            var name: String,
            var image: String
    ) {
        constructor(user: User): this (
                id = user.id,
                email = user.email,
                name = user.name,
                image = user.image
        )
    }
}
