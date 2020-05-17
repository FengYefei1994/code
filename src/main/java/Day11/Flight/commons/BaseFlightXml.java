package Day11.Flight.commons;

import cn.hutool.core.date.DateUtil;
import Day11.Flight.pro.pojo.Flight;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//import cn.kgc.tangcco.commons.date.BaseDate;

/**
 * @author 李昊哲
 * @version 1.1
 */
public abstract class BaseFlightXml extends BaseXML {

    /**
     * 读取xml文件中的内容转为Map存储
     * @param xmlPath 类路径下的xml为文件路径
     * @return xml解析后的Map
     */
    public static Map<String, Flight> parseXml(String xmlPath) throws DocumentException/*, ParseException _用datebase时间解析抛出的异常*/{
        Map<String,Flight> map = new HashMap<String,Flight>();
        // 获取根元素
        Element rootElement = getRootElement(xmlPath);
        // 获取根元素下所有flight元素的迭代器
        Iterator<Element> it = rootElement.elementIterator("flight");
        Element element = null;
        String flightNo = null;
        String departureCity = null;
        String departureTime = null;
        String arrivalCity = null;
        String arrivalTime = null;
        Flight flight = null;
        while (it.hasNext()){
            // 获取每个Element
            element = it.next();
            // 获取航班编号
            flightNo = element.attributeValue("flightNo");
            // 获取航班起飞城市
            departureCity = element.elementTextTrim("departureCity");
            // 获取航班起飞时间
            departureTime = element.elementTextTrim("departureTime");
            // 获取航班抵达城市
            arrivalCity = element.elementTextTrim("arrivalCity");
            // 获取航班抵达时间
            arrivalTime = element.elementTextTrim("arrivalTime");
            // 将航班信息封装到对对象中存储

            //(String flightNo, String departureCity, Date departureTime, String arrivalCity,Date arrivalTime)
            //自定义的时间解析工具
            // flight = new Flight(flightNo, departureCity, BaseDate.parse(departureTime), arrivalCity, BaseDate.parse(arrivalTime));

            // 用hutools的时间解析
            flight = new Flight(flightNo, departureCity, DateUtil.parse(departureTime), arrivalCity, DateUtil.parse(arrivalTime));


            // 将航班信息对象存在Ma中
            map.put(flightNo,flight);
        }
        return map;
    }
    public static void saveXml(String xmlPath, Map<String,Flight> flightMap) {

    }
}
