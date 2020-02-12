package com.example.healthmonitoringsystem;

import java.util.Map;

public class SaveForMA {

    private Map<String, Integer> logAndOld;

    public SaveForMA(Map<String, Integer> logAndOld) {
        this.logAndOld = logAndOld;
    }

    @Override
    public String toString() {
        return "SaveForMA{" +
                "logAndOld=" + logAndOld +
                '}';
    }
}
