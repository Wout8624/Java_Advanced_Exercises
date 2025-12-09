package be.pxl.superhero_backend;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MissionRequest {
    private String missionName;
    private boolean completed;

    public MissionRequest(String missionName, boolean completed) {
        this.missionName = missionName;
        this.completed = completed;
    }
}
