package Day04.TreeSet;

import java.util.Objects;

public class Goods implements Comparable {
    /**
     * supply   供应商
     */
    private String supply;
    /**
     * price    单价
     */
    private int price;
    /**
     * salenum  销量
     */
    private int salenum;

    /**
     * compareto重写——salenum升序—单价升序-供应商hashcode
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        Goods good = (Goods) o;
        int x=this.getSalenum() - good.getSalenum();
        int y=this.getPrice()-good.getPrice();

        if (x!=0) {
            return x;
        }else if(y!=0){
            return y;
        }
        return this.getSupply().compareTo(good.getSupply());
    }
    /**
     * toString重写
     * @return
     */
    @Override
    public String toString() {
        return "Goods[" +
                "supply='" + getSupply() + '\'' +
                ", price=" + getPrice() +
                ", salenum=" + getSalenum() +
                ']';
    }



    public Goods(String supply, int price, int salenum) {
        this.supply = supply;
        this.price = price;
        this.salenum = salenum;
    }
    public Goods() {}

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSalenum() {
        return salenum;
    }

    public void setSalenum(int salenum) {
        this.salenum = salenum;
    }
}
