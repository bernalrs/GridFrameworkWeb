package org.example.market.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: remibernal
 * Date: 15/01/2013
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 */
public class MarketDataTest {

    @Test
    public void getStockQuoteFromWebsite() throws IOException {
        Document doc = Jsoup.connect("http://www.investopedia.com/markets/stocks/ibm").get();
        String title = doc.title();
    }

}
