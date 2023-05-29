package b_linkedlist.b;

/**
 * 功能:双向链表结点类
 *
 * @author caojianbang
 * @date 15.9.22 9:46 PM
 */
public class GoodNode {
    public int id;
    public String name;
    public double price;
    //pre域
    public GoodNode pre;
    //next域
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
