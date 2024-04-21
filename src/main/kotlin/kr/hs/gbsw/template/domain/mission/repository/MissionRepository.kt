package kr.hs.gbsw.template.domain.mission.repository

import kr.hs.gbsw.template.domain.mission.entity.Mission
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface MissionRepository: JpaRepository<Mission, Long> {
    fun findById(missionId: Int): Optional<Mission>
}