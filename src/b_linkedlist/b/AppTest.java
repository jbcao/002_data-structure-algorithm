package b_linkedlist.b;

/**
 * 功能
 *
 * @author caojianbang
 * @date 15.9.22 10:37 PM
 */
public class AppTest {
    public static void main(String[] args) {
        TwoLinkedList twoLinkedList = new TwoLinkedList();
        GoodNode g1 = new GoodNode(1, "good1", 90.0);
        GoodNode g2 = new GoodNode(2, "good1", 90.0);
        GoodNode g3 = new GoodNode(3, "good1", 90.0);
        GoodNode g4 = new GoodNode(4, "good1", 90.0);
        twoLinkedList.addLast(g1);
        twoLinkedList.addLast(g2);
        twoLinkedList.addLast(g3);
        twoLinkedList.addLast(g4);
        twoLinkedList.delNode(4);
        twoLinkedList.updateNode(new GoodNode(3, "good1", 90.9));
        twoLinkedList.list();
    }
}
