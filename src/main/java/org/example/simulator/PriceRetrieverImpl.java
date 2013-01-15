package org.example.simulator;

import org.example.model.Stock;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 15/01/13
 * Time: 17:43
 * To change this template use File | Settings | File Templates.
 */
public class PriceRetrieverImpl implements PriceRetriever {
    @Override
    public Stock getStock(String symbol) throws IOException {
        Document doc = Jsoup.connect("http://www.investopedia.com/markets/stocks/"+symbol).get();
        Elements table = doc.getElementById("MarketsSummary").getElementsByTag("table");
        Elements td = table.select("td");

        Stock stock = new Stock();
        stock.setSymbol(symbol);
        stock.setPrice(Double.parseDouble(td.get(1).text().trim()));

        return stock;
    }
}
