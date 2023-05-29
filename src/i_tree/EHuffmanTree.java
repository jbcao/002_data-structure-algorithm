package i_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 功能 赫夫曼树
 *
 * @author caojianbang
 * @date 9.11.22 12:34 AM
 */
public class EHuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node huffmanTree = createHuffmanTree(arr);
       preOrder(huffmanTree);
    }

    //前序遍历
    public  static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("树wield空，无法遍历");
        }

    }

    public static Node createHuffmanTree(int[] a) {
        //数组构成节点，存入集合
        List<Node> nodes = new ArrayList<Node>();
        for (int val : a) {
            nodes.add(new Node(val));
        }
        //循环整个过程
        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);
            //取最小两个树，构成树
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(left.value + right.value);
            //设置左右节点
            parent.left=left;
            parent.right=right;
            //删除使用过的两个树
            nodes.remove(0);
            nodes.remove(0);
            //将新树加入集合
            nodes.add(parent);
        }
        //返回根节点
        return nodes.get(0);
    }
}

class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}