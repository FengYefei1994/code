package Day010.XML.Entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import Day010.XML.Commons.BaseDate;

/**
 * @author 李昊哲
 * @version 1.0
 */

public class Emp {
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 性别   1代表男性   2代表女性
     */
    private Integer gender;
    /**
     * 出生日期
     */

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    public Emp() {}

    public Emp(String account, String password, String nickname, Integer gender, Date birthday) {
        this.account = account;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {

        return "Emp{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender=" + gender +
                ", birthday=" + BaseDate.getDateString(birthday)  +
                '}';
    }
}
