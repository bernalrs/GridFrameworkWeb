package org.example.dao;

import org.example.simulator.MarketData;
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
        String expected = "<org.example.simulator.MarketData>\n" +
                "  <success>true</success>\n" +
                "  <message>Loaded</message>\n" +
                "  <data>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>3m Co</company>\n" +
                "      <price>71.72</price>\n" +
                "      <closePrice>71.72</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Alcoa Inc</company>\n" +
                "      <price>29.01</price>\n" +
                "      <closePrice>29.01</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Altria Group Inc</company>\n" +
                "      <price>83.81</price>\n" +
                "      <closePrice>83.81</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>American Express Company</company>\n" +
                "      <price>52.55</price>\n" +
                "      <closePrice>52.55</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>American International Group, Inc.</company>\n" +
                "      <price>64.13</price>\n" +
                "      <closePrice>64.13</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Golddman Sachs Int</company>\n" +
                "      <price>100.61</price>\n" +
                "      <closePrice>100.61</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Boeing Co.</company>\n" +
                "      <price>75.43</price>\n" +
                "      <closePrice>75.43</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Caterpillar Inc.</company>\n" +
                "      <price>67.27</price>\n" +
                "      <closePrice>67.27</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Citigroup, Inc.</company>\n" +
                "      <price>49.37</price>\n" +
                "      <closePrice>49.37</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>E.I. du Pont de Nemours and Company</company>\n" +
                "      <price>40.48</price>\n" +
                "      <closePrice>40.48</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Exxon Mobil Corp</company>\n" +
                "      <price>68.1</price>\n" +
                "      <closePrice>68.1</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>General Electric Company</company>\n" +
                "      <price>34.14</price>\n" +
                "      <closePrice>34.14</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>General Motors Corporation</company>\n" +
                "      <price>0.27</price>\n" +
                "      <closePrice>0.27</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Hewlett-Packard Co.</company>\n" +
                "      <price>36.53</price>\n" +
                "      <closePrice>36.53</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Honeywell Intl Inc</company>\n" +
                "      <price>38.77</price>\n" +
                "      <closePrice>38.77</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Intel Corporation</company>\n" +
                "      <price>19.88</price>\n" +
                "      <closePrice>19.88</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>International Business Machines</company>\n" +
                "      <price>81.41</price>\n" +
                "      <closePrice>81.41</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Johnson &amp; Johnson</company>\n" +
                "      <price>64.72</price>\n" +
                "      <closePrice>64.72</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>JP Morgan &amp; Chase &amp; Co</company>\n" +
                "      <price>45.73</price>\n" +
                "      <closePrice>45.73</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>McDonald s Corporation</company>\n" +
                "      <price>36.76</price>\n" +
                "      <closePrice>36.76</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Merck &amp; Co., Inc.</company>\n" +
                "      <price>40.96</price>\n" +
                "      <closePrice>40.96</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>1.01</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Microsoft Corporation</company>\n" +
                "      <price>25.84</price>\n" +
                "      <closePrice>25.84</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Pfizer Inc</company>\n" +
                "      <price>27.96</price>\n" +
                "      <closePrice>27.96</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>The Coca-Cola Company</company>\n" +
                "      <price>29.0</price>\n" +
                "      <closePrice>29.0</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>The Home Depot, Inc.</company>\n" +
                "      <price>34.64</price>\n" +
                "      <closePrice>34.64</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>The Procter &amp; Gamble Company</company>\n" +
                "      <price>61.91</price>\n" +
                "      <closePrice>61.91</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>United Technologies Corporation</company>\n" +
                "      <price>63.26</price>\n" +
                "      <closePrice>63.26</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Verizon Communications</company>\n" +
                "      <price>35.57</price>\n" +
                "      <closePrice>35.57</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>Moore</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Wal-Mart Stores Inc.</company>\n" +
                "      <price>45.45</price>\n" +
                "      <closePrice>45.45</closePrice>\n" +
                "      <change>0.0</change>\n" +
                "      <pctChange>0.0</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>Moore</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "  </data>\n" +
                "</org.example.simulator.MarketData>";
        DataLoader dataLoader = new DataLoader("./src/test/resources/xml.xml");
        MarketData marketData = dataLoader.getMarketData();
        String actual = marketData.toXML();
        assertEquals(expected, actual);

    }
}
