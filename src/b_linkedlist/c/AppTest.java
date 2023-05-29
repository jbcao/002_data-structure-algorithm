package b_linkedlist.c;

/**
 * 功能
 *
 * @author caojianbang
 * @date 16.9.22 2:37 PM
 */
public class AppTest {
    public static void main(String[] args) {
        CircleSingleLinkedlist circleSingleLinkedlist = new CircleSingleLinkedlist();
        circleSingleLinkedlist.addBoy(10);
        circleSingleLinkedlist.showBoy();
        circleSingleLinkedlist.countBoy(3,2,10);
    }
}
