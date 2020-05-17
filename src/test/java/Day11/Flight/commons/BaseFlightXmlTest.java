package Day11.Flight.commons;

import Day11.Flight.pro.pojo.Flight;
import com.alibaba.fastjson.JSON;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.util.Map;

public class BaseFlightXmlTest {
    @Test
    public void parseXml(){
        try {
            Map<String, Flight> flightMap = BaseFlightXml.parseXml("db/flights.xml");
            //循环拿取map的value值异常
            flightMap.forEach((key,value) ->{
                System.out.println("key >>> " + key + "\t value >>> " + JSON.toJSONString(value));
            });
            //普通循环
            /*
            Iterator<String> it=flightMap.keySet().iterator();
            while(it.hasNext()){
                String key=it.next();
                System.out.println("key >>> " + key + "\tvalue >>> " + flightMap.get(key));
            }*/
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
