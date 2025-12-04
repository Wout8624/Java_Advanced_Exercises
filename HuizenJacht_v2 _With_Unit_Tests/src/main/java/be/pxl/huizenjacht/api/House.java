package be.pxl.huizenjacht.api;


import be.pxl.huizenjacht.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class House {
    private String code;
    private String Description;
    private Status status = Status.FOR_SALE;
    private String city;
    @JsonProperty("area")
    private double area;
    private EPCScore EpcScore;
    private final double basisprijsPerM2 = 2356.75;

    public House(String code, String Description, String city, double area, EPCScore score) {
        this.code = code;
        this.Description = Description;
        this.city = city.toLowerCase();
        this.area = area;
        this.EpcScore = score;
    }

    public House(String code, String description, double area, EPCScore epcScore) {
        this.code = code;
        Description = description;
        this.area = area;
        EpcScore = epcScore;
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
                ", name='" + Description + '\'' +
                ", status=" + status +
                ", city='" + city + '\'' +
                ", price=" + getPrice() +
                '}';
    }

}
