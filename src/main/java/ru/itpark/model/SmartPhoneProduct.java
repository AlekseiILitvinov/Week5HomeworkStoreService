package ru.itpark.model;

import lombok.Data;

@Data
public class SmartPhoneProduct extends Product {
    private static final String CATEGORY_NAME = "Смартфоны";
    private String manufacturer;
    private String color;
    private int diagonalInch;
    private int weightG;
    private int numberOfSim;

    public SmartPhoneProduct(long id, String name, String description, int priceKop, int rating, String manufacturer, String color, int diagonalInch, int weightG, int numberOfSim) {
        super(id, name, description, CATEGORY_NAME, priceKop, rating);
        this.manufacturer = manufacturer;
        this.color = color;
        this.diagonalInch = diagonalInch;
        this.weightG = weightG;
        this.numberOfSim = numberOfSim;
    }

    @Override
    public String toString() {
        return super.toString() + "SmartPhoneProduct{" +
                "manufacturer='" + manufacturer + '\'' +
                ", color='" + color + '\'' +
                ", diagonalInch=" + diagonalInch +
                ", weightG=" + weightG +
                ", numberOfSim=" + numberOfSim +
                "} ";
    }
}
