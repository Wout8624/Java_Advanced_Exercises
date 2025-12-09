package be.pxl.superhero_backend;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public class MissionServiceImpl implements MissionService {
    private final MissionRepository missionRepository;

    @Autowired
    public MissionServiceImpl(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    @Override
    public List<MissionDTO> findAllMissions() {
        return missionRepository.findAll()
                .stream().map(MissionDTO::new)
                .toList();
    }

    @Override
    public MissionDTO findMissionById(Long missionId) {
        return missionRepository.findById(missionId)
                .map(MissionDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Mission", "ID", missionId));
    }

    @Override
    public Long createMission(MissionRequest missionRequest) {
        Mission mission = new Mission();
        mission.setName(missionRequest.getMissionName());
        mission.setCompleted(missionRequest.isCompleted());
        Mission newMission = missionRepository.save(mission);
        return newMission.getId();
    }

    @Override
    public MissionDTO updateMission(Long missionId, MissionRequest missionRequest) {
        return missionRepository.findById(missionId).map(mission -> {
            mission.setName(missionRequest.getMissionName());
            mission.setCompleted(missionRequest.isCompleted());
            return new MissionDTO(missionRepository.save(mission));
        }).orElseThrow(() -> new ResourceNotFoundException("Mission", "ID", missionId));
    }

    @Override
    public boolean deletenMission(Long missionId) {
        return missionRepository.findById(missionId)
                .map(mission -> {
                    missionRepository.delete(mission);
                    return true;
                }).orElseThrow(() -> new ResourceNotFoundException("Mission", "ID", missionId));
    }
}
