package kr.hs.gbsw.template.util.image

import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.IOException
import java.nio.file.Path
import java.text.SimpleDateFormat
import java.util.*
import kotlin.jvm.Throws

@Component
class ImageUploader {
    private val PATH: String = "./images"

    @Throws(IOException::class)
    fun upload(mutlipartFile: MultipartFile, directory: String): Image {
        val originalFileName: String = mutlipartFile.originalFilename!!
        val imageName = createImageName(originalFileName)
        val imagePath = "$PATH/$directory/$imageName"
        val path: Path = Path.of(imagePath).toAbsolutePath()
        val file: File = path.toFile()

        file.parentFile.mkdirs()
        mutlipartFile.transferTo(file)
        return Image(originalFileName, imageName)
    }

    private fun createImageName(fileName: String): String {
        val dateFormat = SimpleDateFormat("yyyyMMddHHmmss")
        return dateFormat.format(Date()) + '_' + fileName
    }
}