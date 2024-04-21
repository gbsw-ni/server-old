package kr.hs.gbsw.template.domain.mission.service

import kr.hs.gbsw.template.domain.mission.dto.MissionDto
import kr.hs.gbsw.template.domain.mission.entity.Mission
import kr.hs.gbsw.template.domain.mission.repository.MissionRepository
import kr.hs.gbsw.template.domain.user.dto.UserDto
import kr.hs.gbsw.template.domain.user.repository.UserRepository

class MissionService (
    private val userRepository: UserRepository,
    private val missionRepository: MissionRepository
) {

    fun create(missionDto: MissionDto.Create) {
    }
}