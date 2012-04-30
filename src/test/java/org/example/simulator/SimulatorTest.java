package org.example.simulator;

import org.example.dao.DataLoader;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: remibernal
 * Date: 29.04.12
 * Time: 20:05
 * To change this template use File | Settings | File Templates.
 */
public class SimulatorTest {

    @Test
    public void testGetNextTicker() throws Exception {
        String expected = "<org.example.simulator.MarketData>\n" +
                "  <success>true</success>\n" +
                "  <message>Loaded</message>\n" +
                "  <data>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>3m Co</company>\n" +
                "      <price>65.14393773451526</price>\n" +
                "      <closePrice>71.72</closePrice>\n" +
                "      <change>-6.576062265484743</change>\n" +
                "      <pctChange>-0.09169077336147159</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Alcoa Inc</company>\n" +
                "      <price>26.694629678862178</price>\n" +
                "      <closePrice>29.01</closePrice>\n" +
                "      <change>-2.3153703211378227</change>\n" +
                "      <pctChange>-0.07981283423432688</pctChange>\n" +
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
                "      <price>70.2205846342066</price>\n" +
                "      <closePrice>64.13</closePrice>\n" +
                "      <change>6.090584634206607</change>\n" +
                "      <pctChange>0.09497247207557473</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Golddman Sachs Int</company>\n" +
                "      <price>103.28828924825423</price>\n" +
                "      <closePrice>100.61</closePrice>\n" +
                "      <change>2.678289248254229</change>\n" +
                "      <pctChange>0.026620507387478672</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Boeing Co.</company>\n" +
                "      <price>73.96568288839634</price>\n" +
                "      <closePrice>75.43</closePrice>\n" +
                "      <change>-1.464317111603667</change>\n" +
                "      <pctChange>-0.01941292737112113</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Caterpillar Inc.</company>\n" +
                "      <price>69.52943223862744</price>\n" +
                "      <closePrice>67.27</closePrice>\n" +
                "      <change>2.259432238627434</change>\n" +
                "      <pctChange>0.03358751655459245</pctChange>\n" +
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
                "      <price>39.67239419601552</price>\n" +
                "      <closePrice>40.48</closePrice>\n" +
                "      <change>-0.8076058039844782</change>\n" +
                "      <pctChange>-0.019950736264438693</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Exxon Mobil Corp</company>\n" +
                "      <price>61.33878649880376</price>\n" +
                "      <closePrice>68.1</closePrice>\n" +
                "      <change>-6.761213501196233</change>\n" +
                "      <pctChange>-0.0992836050102237</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>General Electric Company</company>\n" +
                "      <price>38.29779518321986</price>\n" +
                "      <closePrice>34.14</closePrice>\n" +
                "      <change>4.157795183219862</change>\n" +
                "      <pctChange>0.12178661930931053</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>General Motors Corporation</company>\n" +
                "      <price>8.453157406388504</price>\n" +
                "      <closePrice>0.27</closePrice>\n" +
                "      <change>8.183157406388505</change>\n" +
                "      <pctChange>30.307990394031496</pctChange>\n" +
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
                "      <price>37.113100571869445</price>\n" +
                "      <closePrice>38.77</closePrice>\n" +
                "      <change>-1.656899428130561</change>\n" +
                "      <pctChange>-0.0427366373002466</pctChange>\n" +
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
                "      <price>28.956753262116322</price>\n" +
                "      <closePrice>25.84</closePrice>\n" +
                "      <change>3.116753262116323</change>\n" +
                "      <pctChange>0.12061738630481127</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Pfizer Inc</company>\n" +
                "      <price>31.137668699511508</price>\n" +
                "      <closePrice>27.96</closePrice>\n" +
                "      <change>3.177668699511508</change>\n" +
                "      <pctChange>0.11365052573360186</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>The Coca-Cola Company</company>\n" +
                "      <price>35.10462224966497</price>\n" +
                "      <closePrice>29.0</closePrice>\n" +
                "      <change>6.104622249664974</change>\n" +
                "      <pctChange>0.21050421550568876</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>The Home Depot, Inc.</company>\n" +
                "      <price>24.979199934409888</price>\n" +
                "      <closePrice>34.64</closePrice>\n" +
                "      <change>-9.660800065590113</change>\n" +
                "      <pctChange>-0.278891456858837</pctChange>\n" +
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
                "      <price>72.15085122218422</price>\n" +
                "      <closePrice>63.26</closePrice>\n" +
                "      <change>8.890851222184216</change>\n" +
                "      <pctChange>0.14054459725235877</pctChange>\n" +
                "      <lastChange>9/1 12:00am</lastChange>\n" +
                "      <fund>SAC Capital Management</fund>\n" +
                "    </org.example.model.Stock>\n" +
                "    <org.example.model.Stock>\n" +
                "      <company>Verizon Communications</company>\n" +
                "      <price>30.819277393918068</price>\n" +
                "      <closePrice>35.57</closePrice>\n" +
                "      <change>-4.750722606081933</change>\n" +
                "      <pctChange>-0.13355981462136443</pctChange>\n" +
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
        long seed = -3216658182142127913L;
        DataLoader loader = new DataLoader("./src/test/resources/xml.xml");
        MarketData marketdata = loader.getMarketData();
        Simulator simulator = new Simulator(10);
        simulator.getNextTicker(marketdata, seed);
        String actual = marketdata.toXML();
        assertEquals(expected, actual);
    }

}
