package org.example.dao;

import org.example.simulator.MarketDataImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: remibernal
 * Date: 29.04.12
 * Time: 11:35
 * To change this template use File | Settings | File Templates.
 */
public class DataLoaderTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetMarketData() throws Exception {
        String expected = "";
        DataLoader dataLoader = new DataLoader("./src/test/resources/xml.xml");
        MarketDataImpl marketData = dataLoader.getMarketData();
        String actual = marketData.toXML();
        assertEquals(expected, actual);

    }
}
