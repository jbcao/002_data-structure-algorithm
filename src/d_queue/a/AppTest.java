package d_queue.a;

/**
 * 功能
 *
 * @author caojianbang
 * @date 16.9.22 5:08 PM
 */
public class AppTest {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(100);
        queue.addQueue(3);
        queue.addQueue(1);
        queue.addQueue(4);
        queue.addQueue(6);
        //展示所有数据
        queue.showQueue();
        //展示有用
        queue.showQueue2();
        System.out.println("-------------------");
        queue.getQueue();
        queue.showQueue2();
        System.out.println(queue.head());
    }
}
