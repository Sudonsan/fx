package com.forex.forex;

import java.awt.*;
import java.math.BigDecimal;

public class Candles {
    String historyDate;
    Double bidOpen;
    Double bidclose;
    Double bidhigh;
    Double bidlow;
    Double askopen;
    Double askclose;
    Double askhigh;
    Double asklow;
    Double tickqty;

    public String getHistoryDate() {
        return historyDate;
    }

    public void setHistoryDate(String historyDate) {
        this.historyDate = historyDate;
    }

    public Double getBidOpen() {
        return bidOpen;
    }

    public void setBidOpen(Double bidOpen) {
        this.bidOpen = bidOpen;
    }

    public Double getBidclose() {
        return bidclose;
    }

    public void setBidclose(Double bidclose) {
        this.bidclose = bidclose;
    }

    public Double getBidhigh() {
        return bidhigh;
    }

    public void setBidhigh(Double bidhigh) {
        this.bidhigh = bidhigh;
    }

    public Double getBidlow() {
        return bidlow;
    }

    public void setBidlow(Double bidlow) {
        this.bidlow = bidlow;
    }

    public Double getAskopen() {
        return askopen;
    }

    public void setAskopen(Double askopen) {
        this.askopen = askopen;
    }

    public Double getAskclose() {
        return askclose;
    }

    public void setAskclose(Double askclose) {
        this.askclose = askclose;
    }

    public Double getAskhigh() {
        return askhigh;
    }

    public void setAskhigh(Double askhigh) {
        this.askhigh = askhigh;
    }

    public Double getAsklow() {
        return asklow;
    }

    public void setAsklow(Double asklow) {
        this.asklow = asklow;
    }

    public Double getTickqty() {
        return tickqty;
    }

    public void setTickqty(Double tickqty) {
        this.tickqty = tickqty;
    }


}
