package kr.hs.gbsw.template.util.image

import jakarta.persistence.Embeddable
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
data class Image (
    var originalImageName: String,
    var imageName: String
)