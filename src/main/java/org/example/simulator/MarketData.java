package org.example.simulator;

import org.example.model.Stock;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 15/01/13
 * Time: 17:22
 * To change this template use File | Settings | File Templates.
 */
public interface MarketData {
    List<Stock> getData();

    void getNextTicket();
}
