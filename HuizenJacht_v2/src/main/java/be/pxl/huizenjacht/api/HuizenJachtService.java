package be.pxl.huizenjacht.api;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HuizenJachtService {
    //private final List<House> houseList = new ArrayList<>();
    private final Map<String, House> houseList = new HashMap<>();

//    public void addHouse(House house) {
//        houseList.add(house);
//    }

    public void addHouse(House house) {
        houseList.put(house.getCode(), house);
    }

//    public List<House> getHouseList() {
//        return houseList;
//    }

    public Collection<House> getHouseList() {
        return houseList.values();
    }

//    public void updateHouse(int index, House house) {
//        houseList.set(index, house);
//    }

    public void updateHouse(House house) {
        houseList.put(house.getCode(), house);
    }

//    public void deleteHouse(int index) {
//        houseList.remove(index);
//    }

    public void deleteHouse(String houseCode) {
        houseList.remove(houseCode);
    }
}
