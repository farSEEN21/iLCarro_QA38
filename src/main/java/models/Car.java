package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString

public class Car {
    String locat;
    String make;
    String Model;
    String year;
    String fuel;
    String seat;
    String carClass;
    String serialNumberPlate;
    String price;
    String about;




}
