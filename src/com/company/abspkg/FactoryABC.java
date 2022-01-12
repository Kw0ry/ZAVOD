package com.company.abspkg;

abstract public class FactoryABC {
    public float quantityOfMoney;
    public float factoryPollution;

    public FactoryABC (float quantityOfMoney, float factoryPollution){
        this.quantityOfMoney = quantityOfMoney;
        this.factoryPollution = factoryPollution;
    }

    public abstract void factoryManagement();
    public abstract void factoryDeleted();
}
