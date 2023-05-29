package h_hashtable;

/**
 * 功能 哈希表
 *
 * @author caojianbang
 * @date 26.10.22 6:33 PM
 */
public class HashTable {
    public static void main(String[] args) {
HashTable hashTable = new HashTable(7);
Emp emp= new Emp(12,"cjb");
hashTable.add(emp);
hashTable.list();
hashTable.findEmpById(12);
    }

    //链表数组
    private EmpLinkedList[] hashTable;
    //链表数量
    private int size;

    //构造函数
    public HashTable(int size) {
        this.size = size;
        hashTable = new EmpLinkedList[size];
        //分别初始化链表，因为是非简单类型
        for (int i = 0; i < size; i++) {
            hashTable[i] = new EmpLinkedList();
        }
    }

    //增加
    public void add(Emp emp) {
        int listNo = hashFun(emp.id);
        hashTable[listNo].add(emp);
    }

    //查询
    public void findEmpById(int id) {
        int listNo = hashFun(id);
        Emp emp = hashTable[listNo].findEmpById(id);
        if (emp != null) {
            System.out.println("在" + listNo + "里");
        } else {
            System.out.println("没找到");
        }
    }

    //遍历
    public void list() {
        for (int i = 0; i < size; i++) {
            hashTable[i].list();
        }
    }

    //散列函数
    public int hashFun(int id) {
        return id % size;
    }
}

//雇员链表
class EmpLinkedList {
    //头结点,头结点指向第一个节点
    private Emp head;

    //增加
    public void add(Emp emp) {
        //是第一个
        if (head == null) {
            head = emp;
            return;
        }
        //不是第一个,要找最后一个
        //借助临时节点
        Emp tmp = head;
        while (true) {
            //退出条件
            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;
        }
        tmp.next = emp;
    }

    //遍历
    public void list() {
        //空链表
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        //非空链表
        //借助临时节点
        Emp tmp = head;
        while (true) {
            System.out.println("id=" + tmp.id + "名字" + tmp.name);
            //退出条件
            if (tmp.next == null) {
                break;
            }
            tmp = tmp.next;//遍历，指针后移动
        }
        System.out.println();
    }

    //查找
    //根据id查找
    public Emp findEmpById(int id) {
        //链表为空
        if (head == null) {
            System.out.println("链表我空");
            return null;
        }
        //临时指针
        Emp tmp = head;
        while (true) {
            //找到
            if (tmp.id == id) {
                break;
            }
            //没找到
            if (tmp.next == null) {
                tmp = null;
                break;
            }
            tmp = tmp.next;
        }
        return tmp;
    }
}

//雇员节点
class Emp {
    //data域
    public int id;
    public String name;
    //next域
    public Emp next;

    //构造器
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}