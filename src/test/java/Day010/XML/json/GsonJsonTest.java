package Day010.XML.json;

import Day010.XML.Commons.BaseDate;
import Day010.XML.Entity.Emp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.text.ParseException;
import java.util.*;

public class GsonJsonTest {
    // Gson gson = new Gson();
    Gson gson = new GsonBuilder().setDateFormat("YYYY-MM-dd HH:mm:ss").create();
    @Test
    public void bean2string() {
        try {
            Date birthday = BaseDate.parse("1983-11-22 20:30:00");
            Emp emp = new Emp("admin", "123456", "李昊哲", 1, BaseDate.parse("1983-11-22 20:30:00"));
            // {"account":"admin","birthday":"1983-11-22 20:30:00","gender":1,"nickname":"李昊哲","password":"123456"}
            String jsonString = gson.toJson(emp);
            System.out.println(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void string2bean() {
        String text = "{\"account\":\"admin\",\"birthday\":\"1983-11-22 20:30:00\",\"gender\":1,\"nickname\":\"李昊哲\",\"password\":\"123456\"}";
        Emp emp = gson.fromJson(text, Emp.class);
        System.out.println(emp.toString());
    }

    @Test
    public void list2string() {
        try {
            List<Emp> list = new ArrayList<Emp>();
            list.add(new Emp("admin", "123456", "李昊哲", 1,BaseDate.parse("1983-11-22 20:30:00")));
            list.add(new Emp("phoenix", "123456", "phoenix", 1,BaseDate.parse("1983-11-22 20:30:00")));
            // [
            //  {"account":"admin","birthday":"1983-11-22 20:30:00","gender":1,"nickname":"李昊哲","password":"123456"},
            //  {"account":"phoenix","birthday":"1983-11-22 20:30:00","gender":1,"nickname":"phoenix","password":"123456"}
            // ]
            String jsonString = gson.toJson(list);
            System.out.println(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void string2list() {
        try {
            List<Emp> list = new ArrayList<Emp>();
            list.add(new Emp("admin", "123456", "李昊哲", 1,BaseDate.parse("1983-11-22 20:30:00")));
            list.add(new Emp("phoenix", "123456", "phoenix", 1,BaseDate.parse("1983-11-22 20:30:00")));
            // [
            //  {"account":"admin","birthday":"1983-11-22 20:30:00","gender":1,"nickname":"李昊哲","password":"123456"},
            //  {"account":"phoenix","birthday":"1983-11-22 20:30:00","gender":1,"nickname":"phoenix","password":"123456"}
            // ]
            String jsonString = gson.toJson(list);
            System.out.println(jsonString);
            List<Emp> empList = gson.fromJson(jsonString,new TypeToken<List<Emp>>(){}.getType());
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
            String jsonString = gson.toJson(map);
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
            String jsonString = gson.toJson(map);
            System.out.println(jsonString);
            Map<String, List<Emp>> stringListHashMap = gson.fromJson(jsonString,new TypeToken<Map<String,List<Emp>>>() {}.getType());
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

