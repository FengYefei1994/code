package Day11.Flight.pro.dao;

import Day11.Flight.pro.pojo.Flight;

import java.util.List;
import java.util.Map;

/**
 * @author 李昊哲
 * @version 1.1
 */
public interface FlightDao {

    /**
     * 	获取所有航班（根据起飞时间升序）
     * @return 所有航班集合
     */
    List<Flight> getAllFlight();
    /**
     * 	根据起飞城市和到达城市查询航班（根据起飞时间升序）
     * @param departureCity	起飞城市
     * @param arrivalCity	到达城市
     * @return	查询到的航班集合
     */
    List<Flight> queryFlightByCity(String departureCity,String arrivalCity);
    /**
     *	 添加航班
     * @param flight 待添加的航班
     * @return		 是否添加成功1/0
     */
    int addFlight(Flight flight);
    /**
     * 	删除航班
     * @param flightNo 待删除的航班编号
     * @return		1：删除成功 / 0:删除是吧
     */
    int deleteFlight(String flightNo);
    /**
     * 	将查询结果导出到txt文件
     * @param flightList	查询到的航班集合
     * @param txtPath		txt文件路径
     */
    void exportToTxt(List<Flight> flightList,String txtPath);

    /**
     * 将航班信息保存到xml文件中
     * @param xmlPath   xml文件存储路径
     * @param flightMap 航班信息
     */
    public void saveXml(String xmlPath, Map<String,Flight> flightMap);
}
