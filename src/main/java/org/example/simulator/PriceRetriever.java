package org.example.simulator;

import org.example.model.Stock;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 15/01/13
 * Time: 17:24
 * To change this template use File | Settings | File Templates.
 */
public interface PriceRetriever
{
    public Stock getStock(String symbol) throws IOException;
}
