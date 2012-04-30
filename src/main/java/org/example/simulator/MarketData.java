package org.example.simulator;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.example.model.Stock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: remibernal
 * Date: 28.04.12
 * Time: 21:03
 * To change this template use File | Settings | File Templates.
 */
public class MarketData {
    private boolean success;
    private String message;
    private List<Stock> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Stock>  getData() {
        return data;
    }

    public void setData(List<Stock>  data) {
        this.data = data;
    }

    public void getNextTicket(){
        for(Stock stock : data){
            double change = Math.random();

        }
    }

    public String toXML() {
        XStream xstream = new XStream();
        return xstream.toXML(this);
    }

    public String toJson() throws JSONException{
        JSONObject json = new JSONObject();
        json.put("success", success );
        json.put("message", message);
        JSONArray array = new JSONArray();
        for(Stock stock : data){
            JSONObject object = new JSONObject(stock);
            array.put(object);
        }
        json.put("data", array);
        return json.toString();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object pObject) {
        return EqualsBuilder.reflectionEquals(this, pObject);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
