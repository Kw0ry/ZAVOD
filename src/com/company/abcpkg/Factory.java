package com.company.abcpkg;

public abstract class Factory {
    public float quantityOfMoney;
    public float factoryPollution;

    public Factory (float quantityOfMoney, float factoryPollution){
        this.quantityOfMoney = quantityOfMoney;
        this.factoryPollution = factoryPollution;
    }

    public abstract void factoryManagement();
    public abstract void factoryDeleted();
}
