package Day08.NIO.Serialization;

import java.io.Serializable;

public class Person implements Serializable {

    //必须声明这个静态变量，保证在后期属性修改时，可以反序列化出原本数据
    private static final long serialVersionUID = 2484932501732741469L;
    private String name;
    private int age;
    private String account;
    transient private String secrect;

    public Person() {
    }

    public Person(String name, int age, String account, String secrect) {
        this.name = name;
        this.age = age;
        this.account = account;
        this.secrect = secrect;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", account='" + account + '\'' +
                ", secrect='" + secrect + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSecrect() {
        return secrect;
    }

    public void setSecrect(String secrect) {
        this.secrect = secrect;
    }
}
