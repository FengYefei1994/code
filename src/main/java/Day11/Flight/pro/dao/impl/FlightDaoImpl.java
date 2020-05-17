package Day11.Flight.pro.dao.impl;

import Day11.Flight.commons.BaseFlightXml;
import Day11.Flight.pro.dao.FlightDao;
import Day11.Flight.pro.pojo.Flight;
import org.dom4j.DocumentException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 李昊哲
 * @version 1.1
 */
public class FlightDaoImpl implements FlightDao {
    /**
     * 存储航班信息
     */
    private static Map<String, Flight> flightMap = null;
    static {
        try {
            flightMap = BaseFlightXml.parseXml("db/flights.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Flight> getAllFlight() {
        List<Flight> flights = new ArrayList<Flight>();
        flightMap.forEach((key,value) ->{
            flights.add(value);
        });
        return flights;
    }

    //自行实现接口中方法
    @Override
    public List<Flight> queryFlightByCity(String departureCity, String arrivalCity) {
        return null;
    }

    @Override
    public int addFlight(Flight flight) {
        return 0;
    }

    @Override
    public int deleteFlight(String flightNo) {
        return 0;
    }

    @Override
    public void exportToTxt(List<Flight> flightList, String txtPath) {
    }

    @Override
    public void saveXml(String xmlPath, Map<String,Flight> flightMap) {
    }
}
