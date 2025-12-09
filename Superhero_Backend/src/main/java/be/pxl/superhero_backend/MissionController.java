package be.pxl.superhero_backend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionController {
    private final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @GetMapping
    public List<MissionDTO> getMissions() {
        return missionService.findAllMissions();
    }

    @GetMapping("/{missionId}")
    public MissionDTO getMissionById(@PathVariable Long missionId) {
        return missionService.findMissionById(missionId);
    }

    @PostMapping
    public ResponseEntity<Long> createMission(@RequestBody MissionRequest missionRequest) {
        return new ResponseEntity<>(missionService.createMission(missionRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{missionId}")
    public MissionDTO updateMission(@PathVariable Long missionId, @RequestBody MissionRequest missionRequest) {
        return missionService.updateMission(missionId, missionRequest);
    }

    @DeleteMapping("/{missionId}")
    public ResponseEntity<Void> deleteMission(@PathVariable Long missionId) {
        boolean deleted = missionService.deletenMission(missionId);
        return deleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}