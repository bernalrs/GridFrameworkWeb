package org.example.market.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
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
        Elements table = doc.getElementById("MarketsSummary").getElementsByTag("table");
        Elements td = table.select("td");
        System.out.println("---Start---");
        System.out.println(td.get(1).text());

    }

}
