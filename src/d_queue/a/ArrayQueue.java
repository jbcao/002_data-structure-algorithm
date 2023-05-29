package d_queue.a;

/**
 * 功能
 *
 * @author caojianbang
 * @date 16.9.22 4:38 PM
 */
public class ArrayQueue {
    private int[] queue;
    private int maxSize;
    private int front;
    private int rear;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        queue=new int[maxSize];
        front=-1;//队列元素之前一个
        rear=-1;//尾部元素
    }

    //判满
    public boolean isFull(){
        return rear==maxSize-1;
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
        //入队
        rear++;
        queue[rear]=n;
    }
    //出队
    public int getQueue(){
        //判空
        if(isEmpty()){
            throw new RuntimeException("空");
        }
        //出队
        front++;
        return queue[front];
    }
    //遍历所有数据
public void showQueue(){
        if(isEmpty()){
            System.out.println("kong");
            return;
        }
        //遍历
        for (int i=0;i<queue.length;i++){
        System.out.println("里面数据"+queue[i]);
    }
}
    //遍历所有有用数据
    //遍历所有数据
    public void showQueue2(){
        if(isEmpty()){
            System.out.println("kong");
            return;
        }
        //遍历
        for (int i=front+1;i<rear+1;i++){
            System.out.println("里面数据"+queue[i]);
        }
    }
    //显示队列头数据,注意不是取出
    public int head(){
        if(isEmpty()){
            throw new RuntimeException("空");
        }
        //显示
        return queue[front+1];
    }

}
