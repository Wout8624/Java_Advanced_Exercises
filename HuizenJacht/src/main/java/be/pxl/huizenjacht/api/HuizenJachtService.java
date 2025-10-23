package be.pxl.huizenjacht.api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HuizenJachtService {
    private final List<House> houseList = new ArrayList<>();

    public void addHouse(House house) {
        houseList.add(house);
    }

    public List<House> getHouseList() {
        return houseList;
    }

    public void updateHouse(int index, House house) {
        houseList.set(index, house);
    }

    public void deleteHouse(int index) {
        houseList.remove(index);
    }
}
