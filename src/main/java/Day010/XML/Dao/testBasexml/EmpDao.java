package Day010.XML.Dao.testBasexml;

import Day010.XML.Entity.Emp;

import java.util.List;

/**
 * @author 李昊哲
 * @version 1.0
 */
public interface EmpDao {
    /**
     * 获取所有员工
     * @return  所有员工
     */
    public List<Emp> selectEmps();
}