package be.pxl.superhero_backend;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MissionDTO {
    private final Long id;
    private final String missionName;
    private final boolean completed;

    public MissionDTO(Long id, String missionName, boolean completed) {
        this.id = id;
        this.missionName = missionName;
        this.completed = completed;
    }

    public MissionDTO(Mission mission) {
        this.id = mission.getId();
        this.missionName = mission.getName();
        this.completed = mission.isCompleted();
    }


}
