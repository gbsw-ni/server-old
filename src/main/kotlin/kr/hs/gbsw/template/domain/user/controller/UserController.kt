package kr.hs.gbsw.template.domain.user.controller

import kr.hs.gbsw.template.domain.user.dto.UserDto
import kr.hs.gbsw.template.domain.user.service.UserService
import kr.hs.gbsw.template.util.image.ImageUploader
import kr.hs.gbsw.template.util.security.JWTUtil
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.jvm.Throws

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
class UserController(
        private val userService: UserService,
        private val jwtUtil: JWTUtil
) {
    @PostMapping
    @Throws(Exception::class)
    fun createUser(@ModelAttribute userDto: UserDto.Request): ResponseEntity<HttpStatus> {
        userService.create(userDto)
        return ResponseEntity(HttpStatus.CREATED)
    }
}