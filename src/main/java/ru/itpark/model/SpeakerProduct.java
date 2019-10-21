package ru.itpark.model;

import lombok.Data;

@Data
public class SpeakerProduct extends Product {
    private static final String CATEGORY_NAME = "Компьютерные колонки";
    private int power;

    public SpeakerProduct(long id, String name, String description, int priceKop, int rating, int power) {
        super(id, name, description, CATEGORY_NAME, priceKop, rating);
        this.power = power;
    }

    @Override
    public String toString() {
        return "SpeakerProduct{" +
                "power=" + power +
                "} " + super.toString();
    }
}
