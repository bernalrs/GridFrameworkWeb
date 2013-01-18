package org.example.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: remibernal
 * Date: 28.04.12
 * Time: 19:29
 * To change this template use File | Settings | File Templates.
 */
public class Stock {


    private String company;
    private String symbol;
    private String exchange;
    private Double lastPrice;
    private Double change;
    private Double quantity;
    private Double costBasis;
    private Double marketValue;
    private Double gain;
    private Double gainPercentage;
    private Double dailyGain;
    private Double overallReturn;
    private Double marketCap;
    private Double openPrice;
    private Double dailyHighPrice;
    private Double dailyLowPrice;
    private Double averageVolume;
    private Double weekHigh52;
    private Double weekLow52;
    private Double earningsPerShare;
    private Double priceEarningsRatio;
    private Double beta;
    private Double return1week;
    private Double return4week;
    private Double return3month;
    private Double returnYeartodate;
    private Double return1year;
    private Double return3year;
    private Double return5year;
    private Double changePercentage;
    private String sector;
    private String industry;
    private Double volume;
    private Double purchasedPrice;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getCostBasis() {
        return costBasis;
    }

    public void setCostBasis(Double costBasis) {
        this.costBasis = costBasis;
    }

    public Double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(Double marketValue) {
        this.marketValue = marketValue;
    }

    public Double getGain() {
        return gain;
    }

    public void setGain(Double gain) {
        this.gain = gain;
    }

    public Double getGainPercentage() {
        return gainPercentage;
    }

    public void setGainPercentage(Double gainPercentage) {
        this.gainPercentage = gainPercentage;
    }

    public Double getDailyGain() {
        return dailyGain;
    }

    public void setDailyGain(Double dailyGain) {
        this.dailyGain = dailyGain;
    }

    public Double getOverallReturn() {
        return overallReturn;
    }

    public void setOverallReturn(Double overallReturn) {
        this.overallReturn = overallReturn;
    }

    public Double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Double marketCap) {
        this.marketCap = marketCap;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    public Double getDailyHighPrice() {
        return dailyHighPrice;
    }

    public void setDailyHighPrice(Double dailyHighPrice) {
        this.dailyHighPrice = dailyHighPrice;
    }

    public Double getDailyLowPrice() {
        return dailyLowPrice;
    }

    public void setDailyLowPrice(Double dailyLowPrice) {
        this.dailyLowPrice = dailyLowPrice;
    }

    public Double getAverageVolume() {
        return averageVolume;
    }

    public void setAverageVolume(Double averageVolume) {
        this.averageVolume = averageVolume;
    }

    public Double getWeekHigh52() {
        return weekHigh52;
    }

    public void setWeekHigh52(Double weekHigh52) {
        this.weekHigh52 = weekHigh52;
    }

    public Double getWeekLow52() {
        return weekLow52;
    }

    public void setWeekLow52(Double weekLow52) {
        this.weekLow52 = weekLow52;
    }

    public Double getEarningsPerShare() {
        return earningsPerShare;
    }

    public void setEarningsPerShare(Double earningsPerShare) {
        this.earningsPerShare = earningsPerShare;
    }

    public Double getPriceEarningsRatio() {
        return priceEarningsRatio;
    }

    public void setPriceEarningsRatio(Double priceEarningsRatio) {
        this.priceEarningsRatio = priceEarningsRatio;
    }

    public Double getBeta() {
        return beta;
    }

    public void setBeta(Double beta) {
        this.beta = beta;
    }

    public Double getReturn1week() {
        return return1week;
    }

    public void setReturn1week(Double return1week) {
        this.return1week = return1week;
    }

    public Double getReturn4week() {
        return return4week;
    }

    public void setReturn4week(Double return4week) {
        this.return4week = return4week;
    }

    public Double getReturn3month() {
        return return3month;
    }

    public void setReturn3month(Double return3month) {
        this.return3month = return3month;
    }

    public Double getReturnYeartodate() {
        return returnYeartodate;
    }

    public void setReturnYeartodate(Double returnYeartodate) {
        this.returnYeartodate = returnYeartodate;
    }

    public Double getReturn1year() {
        return return1year;
    }

    public void setReturn1year(Double return1year) {
        this.return1year = return1year;
    }

    public Double getReturn3year() {
        return return3year;
    }

    public void setReturn3year(Double return3year) {
        this.return3year = return3year;
    }

    public Double getReturn5year() {
        return return5year;
    }

    public void setReturn5year(Double return5year) {
        this.return5year = return5year;
    }

    public Double getChangePercentage() {
        return changePercentage;
    }

    public void setChangePercentage(Double changePercentage) {
        this.changePercentage = changePercentage;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;

    }

    public Double getPurchasedPrice() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(Double purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }


    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this);
    }

    @Override
    public boolean equals(Object pObject) {
        return EqualsBuilder.reflectionEquals(this, pObject);
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
