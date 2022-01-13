package com.company.models;
import com.company.abcpkg.FactoryABC;

public class Factory extends FactoryABC {

    Factory (float quantityOfMoney, float factoryPollution) {
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
