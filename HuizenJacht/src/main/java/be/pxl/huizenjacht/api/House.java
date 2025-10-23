package be.pxl.huizenjacht.api;


import be.pxl.huizenjacht.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class House {
    private String code;
    private String name;
    private Status status = Status.FOR_SALE;
    private String city;
    @JsonProperty("price")
    private double price;

    public House(String code, String name, String city, double price) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.price = price;
    }

    @Override
    public String toString() {
        return "House{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", city='" + city + '\'' +
                ", price=" + price +
                '}';
    }

}
