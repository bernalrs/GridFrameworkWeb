package org.example.simulator;

import org.example.model.Stock;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 15/01/13
 * Time: 17:16
 * To change this template use File | Settings | File Templates.
 */
public interface Simulator {
    MarketDataImpl getNextTicker(MarketDataImpl data);

    MarketDataImpl getNextTicker(MarketDataImpl data, Long seed);

    public Stock getNextTicker(PriceRetriever mockedPriceRetriever, long seed);

    Stock getStock(PriceRetriever mockedPriceRetriever, String symbol) throws IOException;
}
