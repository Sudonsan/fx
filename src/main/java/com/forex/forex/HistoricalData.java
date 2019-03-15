package com.forex.forex;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoricalData {
    @SerializedName("instrument_id")
    double instrumnetId;

    @SerializedName("period_id")
    String periodId;



    @SerializedName("candles")
   // Candles candles;

   List<Candles> candles= new ArrayList<>();


    public double getInstrumnetId() {
        return instrumnetId;
    }

    public void setInstrumnetId(double instrumnetId) {
        this.instrumnetId = instrumnetId;
    }

    public String getPeriodId() {
        return periodId;
    }

    public void setPeriodId(String periodId) {
        this.periodId = periodId;
    }



    public List<Candles> getCandles() {
        return candles;
    }

    public void setCandles(List<Candles> candles) {
        this.candles = candles;
    }







}
