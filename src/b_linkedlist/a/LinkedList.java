package b_linkedlist.a;

/**
 * 功能:单链表
 *
 * @author caojianbang
 * @date 15.9.22 5:14 PM
 */
public class LinkedList {
    //have head node
    private GoodNode head = new GoodNode(0, "", 0.0);

    //add method
    public void add(GoodNode goodNode) {
        GoodNode tmp = head;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;
        }
        tmp.next = goodNode;
    }

    //顺序插入节点
    public void addByOrder(GoodNode goodNode) {
        GoodNode tmp = head;
        boolean flag = false;
        while (true) {
            //空链表
            if (tmp.next == null) {
                break;
            }
            //非空链表，找到
            if (tmp.next.id > goodNode.id) {
                break;
            } else if (tmp.next.id == goodNode.id) {//非空链表。重复
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            System.out.println("重复");
        } else {
            goodNode.next=tmp.next;
            tmp.next = goodNode;
        }
    }

    //修改节点
    public void updateNode(GoodNode goodNode) {
        //删改要判有没有数据
        if (head.next == null) {
            System.out.println("空链表");
            return;
        }
        //临时节点指向链表节点
        GoodNode tmp = head.next;
        boolean flag = false;
        while (true) {
            //找到最后没找到
            if (tmp == null) {
                break;
            }
            //找到
            if (tmp.id == goodNode.id) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }

        //修改
        if (flag) {
            tmp.price = goodNode.price;
            tmp.name = goodNode.name;
        } else {
            System.out.println("没找到");
        }

    }

    //删除节点,根据id删除节点
    public void delNode(int id) {
        GoodNode tmp = head;
        boolean flag = false;
        while (true) {
            //没找到
            if (tmp.next == null) {
                break;
            }
            //找到
            if (tmp.next.id == id) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            tmp.next = tmp.next.next;
        } else {
            System.out.println("没找到");
        }
    }

    //遍历节点
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        GoodNode tmp = head;
        while (true) {
            if (tmp.next == null) {
                System.out.println(tmp);//最后一个要单独输出
                break;
            }
            System.out.println(tmp);
            tmp = tmp.next;
        }
    }
    //统计
    public int getLength(){
        if(head.next==null){
            System.out.println("链表为空");
            return 0;
        }
        GoodNode tmp = head.next;
        int length=0;
        while(true){
            if(tmp==null){
                break;
            }
            length++;
            tmp=tmp.next;
        }
        return length;
    }
}
