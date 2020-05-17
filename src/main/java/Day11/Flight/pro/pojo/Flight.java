package Day11.Flight.pro.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Setter;

import java.util.Date;

/**
 * @author 李昊哲
 * @version 1.1
 */
@Setter
public class Flight implements Comparable{
    /**
     * 航班编号
     */
    private String flightNo;
    /**
     * 起飞城市
     */
    private String departureCity;
    /**
     * 起飞时间
     */

    private Date departureTime;
    /**
     * 到达城市
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private String arrivalCity;
    /**
     * 到达时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date arrivalTime;

    public String getFlightNo() {
        return flightNo;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    /**
     * 初始化Flight
     */
    public Flight() {
        super();
    }

    /**
     * 初始化Flight 并初始化航班号,出发城市,出发时间,到达城市,到达时间
     *
     * @param flightNo      航班编号
     * @param departureCity 起飞城市
     * @param departureTime 起飞时间
     * @param arrivalCity   到达城市
     * @param arrivalTime   到达时间
     */
    public Flight(String flightNo, String departureCity, Date departureTime, String arrivalCity,
                  Date arrivalTime) {
        super();
        this.flightNo = flightNo;
        this.departureCity = departureCity;
        this.departureTime = departureTime;
        this.arrivalCity = arrivalCity;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public int compareTo(Object o) {
        Flight flight = (Flight) o;
        if (this.getDepartureTime().after(((Flight) o).getDepartureTime())){
            return  1;
        } else if(this.getDepartureTime().before(((Flight) o).getDepartureTime())){
            return  -1;
        } else {
            return 0;
        }
    }
}

