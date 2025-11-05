package be.pxl.huizenjacht.api;


import be.pxl.huizenjacht.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
public class House {
    private String code;
    private String name;
    private Status status = Status.FOR_SALE;
    private String city;
    @JsonProperty("area")
    private double area;
    private EPCScore score;
    private final double basisprijsPerM2 = 2356.75;

    public House(String code, String name, String city, double area, EPCScore score) {
        this.code = code;
        this.name = name;
        this.city = city.toLowerCase();
        this.area = area;
        this.score = score;
    }

    public double getPrice() {
        double price;
        if (city.equals("genk")) {
            price = (basisprijsPerM2 * 1.25) * area;
        } else {
            price = basisprijsPerM2 * area;
        }
        return price;
    }

    public void markAsSold() {
        if (status == Status.SOLD) {
            throw new IllegalStateException("The House is already sold!");
        } else {
            status = Status.SOLD;
        }
    }

    @Override
    public String toString() {
        return "House{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", city='" + city + '\'' +
                ", price=" + getPrice() +
                '}';
    }

}
