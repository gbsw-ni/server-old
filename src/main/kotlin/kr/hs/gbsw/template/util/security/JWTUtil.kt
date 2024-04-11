package kr.hs.gbsw.template.util.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.security.Key

@Component
class JWTUtil(secretCfg: SecretCfg) {

    val key: Key by lazy {
        Keys.hmacShaKeyFor(secretCfg.secret.toByteArray())
    }

    fun generateToken(id: Long): String {
        return Jwts
                .builder()
                .claim("id", id)
                .signWith(key)
                .compact()
    }

    fun getId(token: String): Long {
        val claims: Claims = Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .body

        return claims.get("id", Long::class.java)
    }

    fun validate(token: String): Boolean {
        try {
            Jwts
                    .parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)

            return true
        } catch (ignored: Exception) {}

        return false
    }
}