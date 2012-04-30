package org.example.simulator;

import java.util.Random;
import java.util.List;
import org.example.model.Stock;
import java.util.Random;
import org.example.dao.DataLoader;

/**
 * Created with IntelliJ IDEA.
 * User: remibernal
 * Date: 29.04.12
 * Time: 18:57
 * To change this template use File | Settings | File Templates.
 */
public class Simulator {

    private final int step;

    public Simulator(int step){
        this.step = step;
    }

    public MarketData getNextTicker(MarketData data){
        return updateData(data, new Random());
    }

    public MarketData getNextTicker(MarketData data, Long seed){
        return updateData(data, new Random(seed));
    }

    protected MarketData updateData(MarketData data, Random random){

        boolean hasChange, direction;
        double decimalIncrement;
        int increment;
        synchronized (DataLoader.class){
            List<Stock> stockList = data.getData();
            for(Stock stock : stockList){
                hasChange = random.nextBoolean();
                if(hasChange){
                    double price = stock.getPrice();
                    double closePrice = stock.getClosePrice();
                    double change = getPriceChange(random.nextBoolean(), random.nextInt(step),random.nextDouble() );
                    stock.setPrice(closePrice + change );
                    stock.setChange(change);
                    stock.setPctChange(change / closePrice);
                }
            }
        }
        return data;
    }

    protected double getPriceChange(boolean direction, int increment, double decimalIncrement){
        return (direction) ? (increment + decimalIncrement) : -1 * (increment + decimalIncrement);
    }

    protected double calculatePrice(double closePrice, double change){
        return closePrice + change;
    }

    protected double calculatePctPriceChange(double closePrice, double change ){
        return change / closePrice;
    }

}
