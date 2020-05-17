package Day11.Flight.pro.view;

import Day11.Flight.pro.controller.FlightHandler;
import Day11.Flight.pro.pojo.Flight;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;

/**
 * @author 李昊哲
 * @version 1.1
 */
public class App {
    public static void main(String[] args) {
        App app = new App();
        app.showAllFlight();
    }
    public void showAllFlight(){
        FlightHandler flightHandler = new FlightHandler();
        String jsonString = flightHandler.getAllFlight();
        Map<String,Object> map = JSON.parseObject(jsonString,new TypeReference<Map<String, Object>>() {
        });
        switch (map.get("code").toString()) {
            case "0":
                // 如果code为0说明返回正常
                // 获取航班信息的集合
                Object data = map.get("data");
                // 把航班信息的集合转为json字符串，因为无法直接解析为集合对象
                String text = JSON.toJSONString(data);
                // 解析json字符串为集合对象
                List<Flight> flights = JSON.parseArray(text, Flight.class);
                flights.forEach(flight -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append("\t航班号 >>> " + flight.getFlightNo());
                    sb.append("\t起飞城市 >>> " + flight.getDepartureCity());
                    sb.append("\t起飞时间 >>> " + flight.getDepartureTime());
                    sb.append("\t抵达城市 >>> " + flight.getArrivalCity());
                    sb.append("\t抵达时间 >>> " + flight.getArrivalTime());
                    System.out.println(sb.toString()) ;
                });
                break;
            default:
                System.out.println("输入有误，系统重置。");
                break;
        }


    }
}
