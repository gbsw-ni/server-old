package kr.hs.gbsw.template.domain.user.controller

import kr.hs.gbsw.template.domain.user.service.UserService
import kr.hs.gbsw.template.util.image.ImageUploader
import kr.hs.gbsw.template.util.security.JWTUtil
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
class UserController(
        private val userService: UserService,
        private val imageUploader: ImageUploader,
        private val jwtUtil: JWTUtil
) {

}