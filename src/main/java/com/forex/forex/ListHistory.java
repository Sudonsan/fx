package com.forex.forex;

import java.util.ArrayList;
import java.util.List;

public class ListHistory {



    List<HistoricalData> mainData = new ArrayList<>();
    public List<HistoricalData> getMainData() {
        return mainData;
    }

    public void setMainData(List<HistoricalData> mainData) {
        this.mainData = mainData;
    }
}
