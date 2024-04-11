package kr.hs.gbsw.template.domain.user.service

import kr.hs.gbsw.template.util.image.ImageUploader
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class UserService(
        private val imageUploader: ImageUploader
) {
}