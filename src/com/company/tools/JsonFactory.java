package com.company.tools;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.*;
import java.util.ArrayList;

public class JsonFactory {
    private final Gson gson = new Gson();

    public void readJsonFile() throws FileNotFoundException {
        try (Reader reader = new FileReader("./data/card_with_factories.json")) {
            Object factory = gson.fromJson(reader, Object.class);
            System.out.println(factory.toString());
//            System.out.println(factory.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}

class Factory {
    @SerializedName("factories")
    ArrayList<DataFactory> factories;
}

class DataFactory {
    @SerializedName("name")
    public String name;
    @SerializedName("question")
    public String question;
    @SerializedName("influences")
    public String influences;
    @SerializedName("yes")
    public ChoiceAnswer[] yes;
    @SerializedName("no")
    public ChoiceAnswer[] no;
}

class ChoiceAnswer {
    @SerializedName("worker_fatigue")
    public int workerFatigue;
    @SerializedName("amount_of_money")
    public int amountOfMoney;
    @SerializedName("pollution")
    public int pollution;
    @SerializedName("answer")
    public String answer;
}
