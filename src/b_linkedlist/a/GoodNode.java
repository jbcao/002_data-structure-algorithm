package b_linkedlist.a;

/**
 * 功能
 *
 * @author caojianbang
 * @date 15.9.22 5:11 PM
 */
public class GoodNode {
    public int id;
    public String name;
    public double price;
    public GoodNode next;

    public GoodNode(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "GoodNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
