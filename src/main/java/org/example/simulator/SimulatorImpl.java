package org.example.simulator;

import java.io.IOException;
import java.util.Random;
import java.util.List;
import org.example.model.Stock;
import org.example.dao.DataLoader;

/**
 * Created with IntelliJ IDEA.
 * User: remibernal
 * Date: 29.04.12                                               /
 * Time: 18:57
 * To change this template use File | Settings | File Templates.
 */
public class SimulatorImpl implements Simulator {

    private final int step;

    public SimulatorImpl(int step){
        this.step = step;
    }

    @Override
    public MarketDataImpl getNextTicker(MarketDataImpl data){
        return updateData(data, new Random());
    }

    @Override
    public MarketDataImpl getNextTicker(MarketDataImpl data, Long seed){
        return updateData(data, new Random(seed));
    }

    @Override
    public Stock getNextTicker(PriceRetriever mockedPriceRetriever, long seed) {
        return new Stock();  //To change body of implemented methods use File | Settings | File Templates.
    }

    protected MarketDataImpl updateData(MarketDataImpl data, Random random){

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

    @Override
    public Stock getStock(PriceRetriever priceRetriever, String ibm) throws IOException {

        return priceRetriever.getStock(ibm);
    }
}
