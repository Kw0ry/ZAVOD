package com.company.models;
import com.company.abcpkg.Factory;

public class FactoryImpl extends Factory {

    FactoryImpl(float quantityOfMoney, float factoryPollution) {
        super(quantityOfMoney, factoryPollution);
    }

    public static String info() {
        return "Информация о Заводе";
    }

    @Override
    public void factoryManagement() {
        // TODO: Надо сделать этот метод, ну это потом
    }

    @Override
    public void factoryDeleted() {
        // TODO: Надо сделать этот метод, ну это потом
    }
}
