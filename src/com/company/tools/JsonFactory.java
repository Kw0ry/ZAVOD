package com.company.tools;

import com.company.tools.factory.FactoryData;
import com.company.tools.factory.FactoryDataStore;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonFactory {
    private final Gson gson = new Gson();

    public void readJsonFile() throws FileNotFoundException {
        FactoryDataStore factoryDataStore = this.gson.fromJson(
                new FileReader("./data/card_with_factories.json"), FactoryDataStore.class);
        for (FactoryData factoryDatum : factoryDataStore.factoryData) {
            System.out.println(factoryDatum);
        }

    }
}
