package i_tree.c;

/**
 * 功能 线索化二叉树
 *
 * @author caojianbang
 * @date 31.10.22 6:37 PM
 */
public class CThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode n1 = new HeroNode(2, "吴用");
        HeroNode n2 = new HeroNode(3, "卢俊宇");
        HeroNode n3 = new HeroNode(4, "林冲");
        HeroNode n4 = new HeroNode(5, "关胜");
        root.setLeft(n1);
        root.setRight(n2);
        n1.setRight(n3);
        n1.setLeft(n4);
        ThreadBinaryTree binaryTree = new ThreadBinaryTree();
        binaryTree.setRoot(root);
        binaryTree.threadNode(root);
        System.out.println(n4.getLeft());
        System.out.println(n4.getRight());
        binaryTree.threadList();
    }
}

//二叉树
class ThreadBinaryTree {
    private HeroNode root;
    private HeroNode pre;//指向当前节点前驱

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //中序线索化遍历
    public void threadList(){
        //存储遍历的结点
        HeroNode node = root;
        while(node!=null){
            //找到线索化头
            while(node.getLeftType()==0){
                node=node.getLeft();
            }

            //输出当前节点
            System.out.println(node);
            //输出后继
            while(node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }

            node=node.getRight();
        }
    }

    //中序线索化
    public void threadNode(HeroNode node) {
        //判空
        if (node == null) {
            return;
        }
        //递归进行左子树线索化
        threadNode(node.getLeft());
        //当前节点
        //处理前驱
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //处理后继，递归到下一个节点才能处理
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //当前节点设为pre
        pre = node;
        //递归进行右子树线索化
        threadNode(node.getRight());

    }

    //前序遍历
    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (root != null) {
            root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序遍历查找 中序遍历查找 后序遍历查找
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }

    }

    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    //删除
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("为空，不能删除");
        }

    }
}

//结点类
class HeroNode {
    private int no;
    private String name;
    //左右节点,默认空
    private HeroNode left;
    private HeroNode right;

    private int leftType;//节点做节点类型 0，左子节点 1，前驱  下面相应的右子节点类型
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    //前序遍历
    public void preOrder() {
        //父节点
        System.out.println(this);
        //左子树递归遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //右子树递归遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {

        //左子树递归遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //父节点
        System.out.println(this);
        //右子树递归遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        //左子树递归遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //右子树递归遍历
        if (this.right != null) {
            this.right.preOrder();
        }
        //父节点
        System.out.println(this);
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.preOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.right != null) {
            res = this.right.preOrderSearch(no);
        }
        return res;

    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.infixOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            res = this.right.infixOrderSearch(no);
        }
        return res;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.postOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.right != null) {
            res = this.right.postOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.no == no) {
            return this;
        }
        return res;
    }

    //删除节点
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }
}