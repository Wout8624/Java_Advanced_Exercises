package be.pxl.superhero_backend;


import org.springframework.stereotype.Service;

import java.util.List;

public interface MissionService {
    List<MissionDTO> findAllMissions();

    MissionDTO findMissionById(Long ID);

    Long createMission(MissionRequest missionRequest);

    MissionDTO updateMission(Long missionId, MissionRequest missionRequest);

    boolean deletenMission(Long missionId);

}
