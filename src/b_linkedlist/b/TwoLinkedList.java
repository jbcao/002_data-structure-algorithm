package b_linkedlist.b;

/**
 * 功能
 *
 * @author caojianbang
 * @date 15.9.22 9:53 PM
 */
public class TwoLinkedList {

    private GoodNode head = new GoodNode(0,"head",90.0);
    //返回头结点
    public GoodNode getHeadNode(){
        return head;
    }
    //添加节点到链表最后面
    public void addLast(GoodNode goodNode){
        GoodNode tmp = head;
        while(true){
            if(tmp.next==null){
                break;
            }
            tmp=tmp.next;
        }
        tmp.next=goodNode;
        goodNode.pre=tmp;
    }
    //修改节点
    public void updateNode(GoodNode goodNode){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        GoodNode tmp=head.next;
        boolean flag =false;
        //循环
        while(true){
            //找到最后没找到
            if(tmp==null){
                break;
            }
            //找到了
            if(tmp.id==goodNode.id){
                flag=true;
                break;
            }
            //没找到，继续往后
            tmp=tmp.next;
        }
        //修改
        if(flag){
            tmp.name=goodNode.name;
            tmp.price=goodNode.price;
        }else {
            System.out.println("链表中没有，找不到");
        }
    }
    //双向链表删除,根据id进行删除
    public void delNode(int id){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表空");
            return;
        }
        GoodNode tmp =head.next;
        boolean flag = false;
        //循环查找
        while (true){
            //找到最后，没找到
            if(tmp==null){
                break;
            }
            //找到
            if(tmp.id==id){
                flag=true;
                break;
            }
            tmp = tmp.next;
        }
        //执行删除
        if(flag){
            //直接前驱的next指向直接后继
            tmp.pre.next=tmp.next;
            //如果存在直接后继，将直接后继的pre指向直接前驱
            if(tmp.next!=null){
                tmp.next.pre=tmp.pre;
            }
        }else {
            System.out.println("没找到");
        }

    }
    //遍历节点
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        GoodNode tmp = head.next;
        while (true) {
            if (tmp.next == null) {
                System.out.println(tmp);//最后一个要单独输出
                break;
            }
            System.out.println(tmp);
            tmp = tmp.next;
        }
    }
}
