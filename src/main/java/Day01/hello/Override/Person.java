package Day01.hello.Override;

public class Person implements Cloneable{
    /**
     * 姓名
     */
    private String nickname;
    /**
     * 年龄
     */
    private int age;
    /**
     * 性别
     */
    private int gender;
    public Person(){

    }

    public Person(String nickname, int age, int gender) {
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + gender;
        result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Person other = (Person) obj;
        if (age != other.age){
            return false;
        }
        if (gender != other.gender){
            return false;
        }
        if (nickname == null) {
            if (other.nickname != null){
                return false;
            }
        } else if (!nickname.equals(other.nickname)){
            return false;
        }
        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person [nickname=" + nickname + ", age=" + age + ", gender=" + ((gender == 1) ? "男" : "女") + "]";
    }

}