package Day11.Flight.pro.controller;

import Day11.Flight.pro.pojo.Flight;
import Day11.Flight.pro.service.FlightService;
import Day11.Flight.pro.service.impl.FlightServiceImpl;
import com.alibaba.fastjson.JSON;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;

/**
 * @author 李昊哲
 * @version 1.1
 */
public class FlightHandler {
    /**
     * 业务逻辑层实例化对象
     */
    private static FlightService flightService = new FlightServiceImpl();

    /**
     * 获取所有航班信息
     * @return  所有航班信息
     */
    public String getAllFlight(){
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        map.put("code",0);
        map.put("msg","");
        SortedSet<Flight> set = flightService.getAllFlight();
        map.put("count",set.size());
        map.put("data",set);
        return JSON.toJSONString(map);
    }
}
