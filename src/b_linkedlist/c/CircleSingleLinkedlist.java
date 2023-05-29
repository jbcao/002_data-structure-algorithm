package b_linkedlist.c;

/**
 * 功能
 *
 * @author caojianbang
 * @date 16.9.22 11:41 AM
 */
public class CircleSingleLinkedlist {
    //首节点
    private Boy first = new Boy(-1);
    //添加节点，给出数量，创建环形链表
    public void addBoy(int num){
        //数字是否合理
        if(num<1){
            System.out.println("给出数字不合理");
            return;
        }
        //添加节点
        Boy tmp=null;
        for (int i = 1; i <=num ; i++) {
            Boy boy = new Boy(i);
            //第一个节点
            if(i==1){
                first=boy;
                boy.setNext(first);
                tmp=first;
            }else {//非第一个节点情况
                tmp.setNext(boy);
                boy.setNext(first);
                tmp=boy;
            }
        }
    }
    //遍历
    public void showBoy(){
        //判链表是否为空
        if(first==null){
            System.out.println("无数据");return;
        }
        Boy tmp= first;
        //遍历
        while(true){
            //输出
            System.out.println(tmp);
            //停止条件
            if(tmp.getNext()==first){
                break;
            }
            tmp=tmp.getNext();
        }
    }
    //计算出圈节点顺序
    public void countBoy(int start,int count,int num){
        //参数判断
        if(first==null||start<1||start>num){
            System.out.println("入参错误");
            return;
        }
        //helper移动到最后
        Boy helper = first;
        while (true){
            //跳出条件
            if(helper.getNext()==first){
                break;
            }
            //后移动
            helper=helper.getNext();
        }
        //helper和first移动到报数的位置
        //要移动k-1次
        for (int i = 0; i < start-1; i++) {
            first=first.getNext();
            helper=helper.getNext();
        }
        //报数
        while(true){
            //跳出条件
            if(helper==first){
                break;
            }
            //移动m-1次
            for (int j=0;j<count-1;j++){
                first=first.getNext();
                helper=helper.getNext();
            }
            //出圈
            System.out.println("出圈的编号是"+first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈"+first.getNo());

    }
}
