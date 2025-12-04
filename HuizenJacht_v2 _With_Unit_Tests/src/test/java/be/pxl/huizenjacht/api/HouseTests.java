package be.pxl.huizenjacht.api;

import be.pxl.huizenjacht.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HouseTests {

//    Placed the constructor here because I needed to see in what order my properties should be given in that constructor
//
//    public House(String code, String description, Status status, double area, EPCScore epcScore) {
//        this.code = code;
//        Description = description;
//        this.status = status;
//        this.area = area;
//        EpcScore = epcScore;
//    }

    @Test
    public void testConstructor() {
        House house = new House("XYZ789", "2-bedroom apartment", 150, EPCScore.B);
        assertEquals("XYZ789", house.getCode());
        assertEquals("2-bedroom apartment", house.getDescription());
        assertEquals(150, house.getArea());
        assertEquals(EPCScore.B, house.getEpcScore());
        assertEquals(Status.FOR_SALE, house.getStatus());
        assertNull(house.getCity()); // City is not set initially
    }
}
