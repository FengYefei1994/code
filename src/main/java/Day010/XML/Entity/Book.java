package Day010.XML.Entity;

public class Book{
    /**
     * 属性 编号
     */
    private Integer id;
    /**
     * 属性性别
     */
    private Integer price;
    /**
     * 元素的值
     */
    private String value;
    public Book() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Book(Integer id, Integer price, String value) {
        super();
        this.id = id;
        this.price = price;
        this.value = value;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
