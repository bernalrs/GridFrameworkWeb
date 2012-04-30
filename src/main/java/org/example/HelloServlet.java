package org.example;
 
import org.example.dao.DataLoader;
import org.example.simulator.MarketData;
import org.example.simulator.Simulator;
import org.json.JSONException;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class HelloServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // In a real system the data would be optain from a database or service encapsulated in a DAO.
        // Then we would use a JSON library to conver the Object hierarchy into a valid json string.
        try{
            DataLoader loader = new DataLoader("./src/main/resources/marketData.xml");
            MarketData marketdata = loader.getMarketData();
            Simulator simulator = new Simulator(3);
            simulator.getNextTicker(marketdata);
            String json = marketdata.toJson();
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println(json);
        }catch(JSONException e){
            System.out.println("Could not convert object to JSON.");
        }
    }
}
