package d_queue.b;

/**
 * 功能:环形队列，解决复用的问题
 *
 * @author caojianbang
 * @date 16.9.22 8:49 PM
 */
public class CircleArrayQueue {
    private int[] queue;
    private int maxSize;
    private int front = 0;//指向第一个元素
    private int rear=0;//指向最后一个元素的后一个
    //构造方法

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
    }
    //判满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    //判空
    public boolean isEmpty(){
        return rear==front;
    }
    //入队
    public void addQueue(int n){
        //判满
        if(isFull()){
            System.out.println("isfull");
            return;
        }
        //添加
        queue[rear]=n;
        rear=(rear+1)%maxSize;
    }
    //出队
    public int getQueue(){
        //判空
        if(isEmpty()){
            throw new RuntimeException("isempry");
        }
        //取数据
        int value=queue[front];
        front=(front+1)%maxSize;
        return value;
    }
    //遍历
    public void showQueue(){
        //判空
        if(isEmpty()){
            System.out.println("isempty");
            return;
        }
        //输出
        for (int i=front;i<front+size();i++){
            System.out.println(queue[i%maxSize]);
        }
    }
    //显示有效元素个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    //头元素
    public int headQueue(){
        return queue[front];
    }
}
