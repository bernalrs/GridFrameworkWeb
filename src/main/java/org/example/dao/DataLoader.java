package org.example.dao;

import org.example.model.Stock;
import org.example.simulator.MarketDataImpl;
import com.thoughtworks.xstream.XStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: remibernal
 * Date: 28.04.12
 * Time: 20:53
 * To change this template use File | Settings | File Templates.
 */
public class DataLoader {

    private final XStream xstream;
    private final String file;
    private static MarketDataImpl marketData;

    public DataLoader(String file){
        xstream = new XStream();
        this.file = file;
    }

    public MarketDataImpl getMarketData(){
        try{
            synchronized(DataLoader.class){
                if(marketData == null){
                    FileInputStream fis = new FileInputStream(file);
                    xstream.alias("MarketData", MarketDataImpl.class);
                    xstream.alias("Stock", Stock.class);
                    marketData = (MarketDataImpl) xstream.fromXML(fis);
                }
            }
        }catch(FileNotFoundException e){
            System.err.println("Could not load xml File");
        }
        return marketData;
    }
}
