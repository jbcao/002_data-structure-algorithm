package i_tree;

/**
 * 功能 二叉树遍历、查找、删除
 *
 * @author caojianbang
 * @date 31.10.22 6:37 PM
 */
public class ABinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode n1 = new HeroNode(2, "吴用");
        HeroNode n2 = new HeroNode(3, "卢俊宇");
        HeroNode n3 = new HeroNode(4, "林冲");
        HeroNode n4 = new HeroNode(5, "关胜");
        root.setLeft(n1);
        root.setRight(n2);
        n2.setRight(n3);
        n2.setLeft(n4);
        binaryTree.setRoot(root);
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.infixOrder();
        System.out.println("后序遍历");
        binaryTree.postOrder();
        //前序遍历查找
        System.out.println("前序 中序 后序遍历查找");
        HeroNode res=binaryTree.postOrderSearch(5);
        System.out.println(res);
        binaryTree.delNode(5);
        binaryTree.preOrder();
    }
}

//二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
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
    public void delNode(int no){
        if(root!=null){
            if(root.getNo()==no){
                root=null;
            }else {
                root.delNode(no);
            }
        }else {
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
    public void delNode(int no){
        if(this.left!=null&&this.left.no==no){
            this.left=null;
            return;
        }
        if(this.right!=null&&this.right.no==no){
            this.right=null;
            return;
        }
        if(this.left!=null){
            this.left.delNode(no);
        }
        if(this.right!=null){
            this.right.delNode(no);
        }
    }
}