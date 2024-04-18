package kr.hs.gbsw.template.domain.mission.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import kr.hs.gbsw.template.domain.mission.dto.MissionDto

@Entity
data class Mission(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    var name: String,
    var desc: String,

    var rating: Int
) {
    constructor(missionDto: MissionDto.Create): this (
        id = missionDto.id,
        name = missionDto.name,
        desc = missionDto.desc,
        rating = 100
    )
}