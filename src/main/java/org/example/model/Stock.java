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
    private Double price;
    private Double closePrice;
    private Double quantity;
    private Double change;
    private Double pctChange;
    private String lastChange;
    private String fund;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Double getPctChange() {
        return pctChange;
    }

    public void setPctChange(Double pctChange) {
        this.pctChange = pctChange;
    }

    public String getLastChange(){
        return lastChange;
    }

    public void setLastChange(String lastChange) {
        this.lastChange = lastChange;
    }

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
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
