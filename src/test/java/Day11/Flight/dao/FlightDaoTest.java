package Day11.Flight.dao;

import Day11.Flight.pro.dao.FlightDao;
import Day11.Flight.pro.dao.impl.FlightDaoImpl;
import Day11.Flight.pro.pojo.Flight;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class FlightDaoTest {
    private FlightDao flightDao = (FlightDao) new FlightDaoImpl();

    @Test
    public void getAllFlight() {
        List<Flight> flights = flightDao.getAllFlight();
        flights.forEach(flight -> {
            System.out.println(JSON.toJSONString(flight));
        });
    }
}
