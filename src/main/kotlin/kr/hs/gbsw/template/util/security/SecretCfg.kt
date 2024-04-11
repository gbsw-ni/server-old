package kr.hs.gbsw.template.util.security

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "jwt")
class SecretCfg {
    lateinit var secret: String
}