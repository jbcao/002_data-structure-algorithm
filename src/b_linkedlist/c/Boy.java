package b_linkedlist.c;

/**
 * 功能 单向环形队列节点类
 *
 * @author caojianbang
 * @date 16.9.22 11:37 AM
 */
public class Boy {
    private  int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
