package ru.itpark;

import ru.itpark.model.HardDriveProduct;
import ru.itpark.model.SmartPhoneProduct;
import ru.itpark.service.StoreService;

public class Main {
    public static void main(String[] args) {
        StoreService service = new StoreService();

        service.add(new HardDriveProduct(0, "жесткий диск HDD 1ТБ, Western Digital Blue, WD10EZEX",
                "Устройство хранения информации.", 287_000, 4, "Western Digital",
                "HDD", 3, 1_000));

        service.add(new SmartPhoneProduct(0, "Смартфон Xiaomi Redmi GO 1/8Gb black",
                "Изящный дизайн + приятный на ощупь металлический корпус, выглядящий просто потрясающе. " +
                        "Четкий и яркий 5-дюймовый HD дисплей с соотношением сторон 16:9 и разрешением 1280 x 720 " +
                        "идеально подойдет для игр.", 555_000, 5, "Xiaomi", "Черный",
                5, 137, 2));


        System.out.println(service.getSortedBy());
        System.out.println("________________");
        System.out.println(StoreService.sortItems(service.getByCategory("Смартфоны"), 1, 10));
    }
}
