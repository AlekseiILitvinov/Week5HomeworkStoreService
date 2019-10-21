package ru.itpark.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class HardDriveProduct extends Product {
    private static final String CATEGORY_NAME = "Жесткие диски и SSD";
    private String manufacturer;
    private String driveType;
    private int sizeInchPointFive;
    private int volume;
    private Collection<Property> characteristics = new ArrayList<>();

    public HardDriveProduct(long id, String name, String description, int priceKop, int rating, String manufacturer, String driveType, int sizeInchPointFive, int volume) {
        super(id, name, description, CATEGORY_NAME, priceKop, rating);
        this.manufacturer = manufacturer;
        this.driveType = driveType;
        this.sizeInchPointFive = sizeInchPointFive;
        this.volume = volume;
    }

    public boolean addCharacteristic(Property property) {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "HardDriveProduct{" +
                "manufacturer='" + manufacturer + '\'' +
                ", driveType='" + driveType + '\'' +
                ", sizeInchPointFive=" + sizeInchPointFive +
                ", volume=" + volume +
                ", characteristics=" + characteristics +
                "} ";
    }
}
