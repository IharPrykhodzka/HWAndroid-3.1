package com.example.healthmonitoringsystem;

import java.util.List;
import java.util.Map;

public class SaveForPD {

    private List<List> savePD;

    public SaveForPD(List<List> savePD) {
        this.savePD = savePD;
    }

    @Override
    public String toString() {
        return "SaveForPD{" +
                "savePD=" + savePD +
                '}';
    }
}