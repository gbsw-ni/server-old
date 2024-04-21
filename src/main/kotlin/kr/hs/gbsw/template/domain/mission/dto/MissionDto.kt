package kr.hs.gbsw.template.domain.mission.dto

import codes.dya.drive.domain.user.entity.User
import kr.hs.gbsw.template.domain.mission.entity.Mission

class MissionDto {
    data class Create(
        val id: Long,
        var name: String,
        var desc: String,
        val user: User
    )

    data class Read(
        val id: Long,
        var name: String,
        var desc: String,
        var rating: Int,
        val user: User
    ) {
        constructor(mission: Mission): this (
            id = mission.id,
            name = mission.name,
            desc = mission.desc,
            rating = mission.rating,
            user = mission.user
        )
    }

    data class Update(
        val id: Long,
        var name: String,
        var desc: String
    )
}