package d_queue.b;

/**
 * 功能
 *
 * @author caojianbang
 * @date 16.9.22 9:15 PM
 */
public class AppTest {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(3);
        queue.addQueue(3);
        queue.addQueue(4);

        System.out.println(queue.getQueue());
        queue.showQueue();
        queue.addQueue(100);
        queue.showQueue();
    }
}
