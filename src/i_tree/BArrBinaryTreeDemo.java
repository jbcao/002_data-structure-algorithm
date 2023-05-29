package i_tree;

/**
 * 功能 顺序存储二叉树
 *
 * @author caojianbang
 * @date 1.11.22 8:50 PM
 */
public class BArrBinaryTreeDemo {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(a);
        arrBinaryTree.preOrder();
    }
}

//顺序存储二叉树
class ArrBinaryTree {
    //存储数据节点的
    private int[] a;

    public ArrBinaryTree(int[] a) {
        this.a = a;
    }

    public void preOrder() {
        preOrder(0);
    }

    public void preOrder(int index) {
        //判空
        if (a == null || a.length == 0) {
            System.out.println("数组为空，或没有元素");
            return;
        }
        //输出父节点
        System.out.println(a[index]);
        //向左递归遍历
        if (2 * index + 1 < a.length) {
            preOrder(2 * index + 1);
        }
        //右递归遍历
        if (2 * index + 2 < a.length) {
            preOrder(2 * index + 2);
        }
    }
}