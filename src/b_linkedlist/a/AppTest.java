package b_linkedlist.a;

/**
 * 功能
 *
 * @author caojianbang
 * @date 15.9.22 7:23 PM
 */
public class AppTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        GoodNode g1 = new GoodNode(1,"耐克1",90.0);
        GoodNode g2 = new GoodNode(3,"耐克2",90.0);
        GoodNode g3 = new GoodNode(4,"耐克3",90.0);
        GoodNode g4 = new GoodNode(5,"耐克4",90.0);
        linkedList.add(g1);
        linkedList.add(g2);
        linkedList.add(g3);
        linkedList.add(g4);
        GoodNode g5 = new GoodNode(2,"耐克5",90.0);
        linkedList.addByOrder(g5);
        linkedList.updateNode(new GoodNode(4,"耐克3",500.00));
        linkedList.delNode(5);
        System.out.println(linkedList.getLength());
        linkedList.list();

    }
}
