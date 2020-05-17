package Day11.Flight.pro.service.impl;

import Day11.Flight.pro.dao.FlightDao;
import Day11.Flight.pro.dao.impl.FlightDaoImpl;
import Day11.Flight.pro.pojo.Flight;
import Day11.Flight.pro.service.FlightService;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author 李昊哲
 * @version 1.1
 */
public class FlightServiceImpl implements FlightService {
    /**
     * 持久层实例化对象
     */
    private static FlightDao flightDao = (FlightDao) new FlightDaoImpl();

    @Override
    public SortedSet<Flight> getAllFlight() {
        SortedSet<Flight> set = new TreeSet<Flight>();
        List<Flight> flights = flightDao.getAllFlight();
        flights.forEach(flight -> {
            set.add(flight);
        });
        return set;
    }

    @Override
    public SortedSet<Flight> queryFlightByCity(String departureCity, String arrivalCity) {
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
    public void saveXml(String xmlPath) {
    }
}
