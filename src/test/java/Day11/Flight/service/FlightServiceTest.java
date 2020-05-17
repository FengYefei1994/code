package Day11.Flight.service;

import Day11.Flight.pro.pojo.Flight;
import Day11.Flight.pro.service.FlightService;
import Day11.Flight.pro.service.impl.FlightServiceImpl;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Iterator;
import java.util.SortedSet;

public class FlightServiceTest {
    private FlightService flightService = new FlightServiceImpl();
    @Test
    public void test(){
        SortedSet<Flight> set = flightService.getAllFlight();
        Iterator<Flight> it = set.iterator();
        while (it.hasNext()){
            System.out.println(JSON.toJSONString(it.next()));
        }
    }
}
