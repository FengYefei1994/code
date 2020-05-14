package Day010.XML.json;

import Day010.XML.Commons.BaseDate;
import Day010.XML.Entity.Emp;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import java.text.ParseException;
import java.util.*;

public class FastJsonTest {
    @Test
    /*对象转换为字符串*/
    public void bean2string() {
        try {
            Emp emp = new Emp("admin", "123456", "李昊哲", 1, BaseDate.parse("1983-11-22 20:30:00"));
            // {"account":"admin","birthday":"1983-11-22 20:30:00","gender":1,"nickname":"李昊哲","password":"123456"}
            String jsonString = JSON.toJSONString(emp);
            System.out.println(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    /*字符串转对象*/
    public void string2bean() {
        //转义双引号
        String text = "{\"account\":\"admin\",\"birthday\":\"1983-11-22 20:30:00\",\"gender\":1,\"nickname\":\"李昊哲\",\"password\":\"123456\"}";
        Emp emp = JSON.parseObject(text, Emp.class);
        System.out.println(emp.toString());
    }

    @Test
    /*集合转字符串*/
    public void list2string() {
        try {
            List<Emp> list = new ArrayList<Emp>();
            list.add(new Emp("admin", "123456", "李昊哲", 1,BaseDate.parse("1983-11-22 20:30:00")));
            list.add(new Emp("phoenix", "123456", "phoenix", 1,BaseDate.parse("1983-11-22 20:30:00")));
            // [
            //  {"account":"admin","birthday":"1983-11-22 20:30:00","gender":1,"nickname":"李昊哲","password":"123456"},
            //  {"account":"phoenix","birthday":"1983-11-22 20:30:00","gender":1,"nickname":"phoenix","password":"123456"}
            // ]
            String jsonString = JSON.toJSONString(list);
            System.out.println(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    /*字符串转集合，必须准备待解析格式的字符串*/
    public void string2list() {
        try {
            List<Emp> list = new ArrayList<Emp>();
            list.add(new Emp("admin", "123456", "李昊哲", 1,BaseDate.parse("1983-11-22 20:30:00")));
            list.add(new Emp("phoenix", "123456", "phoenix", 1,BaseDate.parse("1983-11-22 20:30:00")));
            // [
            //  {"account":"admin","birthday":"1983-11-22 20:30:00","gender":1,"nickname":"李昊哲","password":"123456"},
            //  {"account":"phoenix","birthday":"1983-11-22 20:30:00","gender":1,"nickname":"phoenix","password":"123456"}
            // ]
            String jsonString = JSON.toJSONString(list);
            System.out.println(jsonString);
            //新建一个泛型列表，用来接收解析的结果
            List<Emp> empList = JSON.parseArray(jsonString, Emp.class);
            empList.forEach(emp -> {
                System.out.println(emp);
            });
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void map2string() {
        try {
            List<Emp> list = new ArrayList<Emp>();
            list.add(new Emp("admin", "123456", "李昊哲", 1,BaseDate.parse("1983-11-22 20:30:00")));
            list.add(new Emp("phoenix", "123456", "phoenix", 1,BaseDate.parse("1983-11-22 20:30:00")));
            Map<String, List<Emp>> map = new HashMap<String, List<Emp>>();
            map.put("emps", list);
            // {"emps":[
            //  {"account":"admin","birthday":"1983-11-22 20:30:00","gender":1,"nickname":"李昊哲","password":"123456"},
            //  {"account":"phoenix","birthday":"1983-11-22 20:30:00","gender":1,"nickname":"phoenix","password":"123456"}]
            // }
            String jsonString = JSON.toJSONString(map);
            System.out.println(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void string2map() {
        try {
            List<Emp> list = new ArrayList<Emp>();
            list.add(new Emp("admin", "123456", "李昊哲", 1,BaseDate.parse("1983-11-22 20:30:00")));
            list.add(new Emp("phoenix", "123456", "phoenix", 1,BaseDate.parse("1983-11-22 20:30:00")));
            Map<String, List<Emp>> map = new HashMap<String, List<Emp>>();
            map.put("emps", list);
            // {"emps":[
            //  {"account":"admin","birthday":"1983-11-22 20:30:00","gender":1,"nickname":"李昊哲","password":"123456"},
            //  {"account":"phoenix","birthday":"1983-11-22 20:30:00","gender":1,"nickname":"phoenix","password":"123456"}]
            // }
            String jsonString = JSON.toJSONString(map);
            System.out.println(jsonString);
            Map<String, List<Emp>> stringListHashMap = JSON.parseObject(jsonString, new TypeReference<Map<String, List<Emp>>>() {
            });
            if (stringListHashMap.containsKey("emps")) {
                List<Emp> emps = stringListHashMap.get("emps");
                emps.forEach(emp -> {
                    System.out.println(emp.toString());
                });
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

