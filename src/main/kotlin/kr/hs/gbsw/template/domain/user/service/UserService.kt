package kr.hs.gbsw.template.domain.user.service

import codes.dya.drive.domain.user.entity.User
import kr.hs.gbsw.template.domain.user.dto.UserDto
import kr.hs.gbsw.template.domain.user.repository.UserRepository
import kr.hs.gbsw.template.util.image.ImageUploader
import lombok.RequiredArgsConstructor
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class UserService(
        private val userRepository: UserRepository,
        private val imageUploader: ImageUploader
) {

    fun create(userDto: UserDto.Request) {
        val existedUser = userRepository.findByEmail(userDto.email)
        if (existedUser.isPresent)
            throw Exception("Email already exists")

        var encryptedPassword = BCrypt.hashpw(userDto.password, BCrypt.gensalt())
        userDto.password = encryptedPassword

        if (userDto.image == null) {
            val user = User(userDto, "default.png")
//            userRepository.save(user)

        }
    }
}