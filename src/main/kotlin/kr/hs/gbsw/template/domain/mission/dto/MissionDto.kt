package kr.hs.gbsw.template.domain.mission.dto

import kr.hs.gbsw.template.domain.mission.entity.Mission

class MissionDto {
    data class Create(
        val id: Long,
        var name: String,
        var desc: String
    )

    data class Read(
        val id: Long,
        var name: String,
        var desc: String,
        var rating: Int
    ) {
        constructor(mission: Mission): this (
            id = mission.id,
            name = mission.name,
            desc = mission.desc,
            rating = mission.rating
        )
    }

    data class Update(
        val id: Long,
        var name: String,
        var desc: String
    )
}