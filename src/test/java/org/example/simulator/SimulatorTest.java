package org.example.simulator;

import org.example.dao.DataLoader;
import org.example.model.Stock;
import org.junit.Before;
import org.junit.Test;
import static org.easymock.EasyMock.*;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: remibernal
 * Date: 29.04.12
 * Time: 20:05
 * To change this template use File | Settings | File Templates.
 */
public class SimulatorTest {

    private Simulator serviceUnderTest;

    @Before
    public void setup()
    {

        serviceUnderTest = new SimulatorImpl(1);
    }


    @Test
    public void testGetNextTicker() throws Exception {



        long seed = -3216658182142127913L;
        //DataLoader loader = new DataLoader("./src/test/resources/xml.xml");
        PriceRetriever mockedPriceRetriever = createMock(PriceRetriever.class);

        Stock expectedData = new Stock();
        expectedData.setSymbol("IBM");
        expectedData.setPrice(23.5);

        expect(mockedPriceRetriever.getStock("IBM")).andReturn(expectedData);
        replay(mockedPriceRetriever);

        //MarketData marketdata = loader.getMarketData();
        SimulatorImpl simulator = new SimulatorImpl(10);

        Stock actual = simulator.getStock(mockedPriceRetriever, "IBM");
        assertEquals(expectedData, actual);
    }

}
