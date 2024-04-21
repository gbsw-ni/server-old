package kr.hs.gbsw.template.domain.mission.entity

import codes.dya.drive.domain.user.entity.User
import jakarta.persistence.*
import kr.hs.gbsw.template.domain.mission.dto.MissionDto

@Entity
data class Mission(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    var name: String,
    var desc: String,

    var rating: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    val user: User

) {
    constructor(missionDto: MissionDto.Create): this (
        id = missionDto.id,
        name = missionDto.name,
        desc = missionDto.desc,
        rating = 100,
        user = missionDto.user
    )
}