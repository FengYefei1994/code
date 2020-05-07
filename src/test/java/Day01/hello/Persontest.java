package Day01.hello;
import org.junit.Test;
import Day01.hello.Override.Person;

public class Persontest {
    @Test
    public void test01() {
        Person person = new Person();
        // 内存中的index表象
        int hashCode = person.hashCode();
        // 输出hashCode
        System.out.println(hashCode);
        // 输出hashCode的十六进制字符串
        System.out.println(Integer.toHexString(hashCode));
        System.out.println(person.toString());
    }
    @Test
    public void test02() {
        Person person = new Person("李昊哲",38,1);
        // 内存中的index表象
        int hashCode = person.hashCode();
        // 输出hashCode
        System.out.println(hashCode);
        // 输出hashCode的十六进制字符串
        System.out.println(Integer.toHexString(hashCode));
        System.out.println(person.toString());
    }
    @Test
    public void test03() {
        Person person01 = new Person("李昊哲",38,1);
        Person person02 = new Person("李昊哲",38,1);
        // 内存中的index表象
        int hashCode01 = person01.hashCode();
        int hashCode02 = person01.hashCode();
        // 输出hashCode
        System.out.println(hashCode01);
        System.out.println(hashCode02);
        // 输出hashCode的十六进制字符串
        System.out.println(Integer.toHexString(hashCode01));
        System.out.println(Integer.toHexString(hashCode02));
        // == 比的是内存地址
        System.out.println(person01 == person02);
        // equals默认比的也是内存地址
        // 但是我可以通过重写equals方法来实现比较规则
        // 注意重写equals方法必须同时重写hashCode方法
        System.out.println(person01.equals(person02));
    }
    @Test
    public void test04() {
        Person person01 = new Person("李昊哲",38,1);
        Person person02 = person01;
        // 内存中的index表象
        int hashCode01 = person01.hashCode();
        int hashCode02 = person01.hashCode();
        // 输出hashCode
        System.out.println(hashCode01);
        System.out.println(hashCode02);
        // 输出hashCode的十六进制字符串
        System.out.println(Integer.toHexString(hashCode01));
        System.out.println(Integer.toHexString(hashCode02));
        // == 比的是内存地址
        System.out.println(person01 == person02);
        // equals默认比的也是内存地址
        // 但是我可以通过重写equals方法来实现比较规则
        // 注意重写equals方法必须同时重写hashCode方法
        System.out.println(person01.equals(person02));
    }
    @Test
    public void test05() {
        Person person01 = new Person("李昊哲",38,1);
        Person person02 = null;
        try {
            person02 = (Person) person01.clone();
            // 内存中的index表象
            int hashCode01 = person01.hashCode();
            int hashCode02 = person01.hashCode();
            // 输出hashCode
            System.out.println(hashCode01);
            System.out.println(hashCode02);
            // 输出hashCode的十六进制字符串
            System.out.println(Integer.toHexString(hashCode01));
            System.out.println(Integer.toHexString(hashCode02));
            // == 比的是内存地址
            System.out.println(person01 == person02);
            // equals默认比的也是内存地址
            // 但是我可以通过重写equals方法来实现比较规则
            // 注意重写equals方法必须同时重写hashCode方法
            System.out.println(person01.equals(person02));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test06() {
        Person person01 = new Person("李昊哲",38,1);
        Person person02 = null;
        try {
            person02 = (Person) person01.clone();
            System.out.println(person01.getNickname());
            System.out.println(person02.getNickname());
            person01.setNickname("phoenix");
            System.out.println(person01.getNickname());
            System.out.println(person02.getNickname());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}