package be.pxl.huizenjacht.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/huizenjacht/houses")
public class HuizenJachtController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HuizenJachtController.class);
    private final HuizenJachtService huizenJachtService;

    @Autowired
    public HuizenJachtController(HuizenJachtService huizenJachtService) {
        this.huizenJachtService = huizenJachtService;
    }

    @PostMapping(path = "/add")
    public void addHouse(@RequestBody House house) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Adding House... [ " + house.getName() + " ]");
        }
        huizenJachtService.addHouse(house);
    }

    @GetMapping(path = "/getHouses")
    public Collection<House> getHouses() {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Getting Houses... ");
        }
        return huizenJachtService.getHouseList();
    }

    @PutMapping(path = "/updateHouse")
    public void updateHouse(@RequestBody House house) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Updating House... [ " + house.getName() + " ]");
        }
        huizenJachtService.updateHouse(house);
    }

    @DeleteMapping(path = "/deleteHouse/{houseCode}")
    public void deleteHouse(@PathVariable String houseCode) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Deleting House... ");
        }
        huizenJachtService.deleteHouse(houseCode);
    }
}
