package i_tree;

/**
 * 功能
 *
 * @author caojianbang
 * @date 25.11.22 9:06 PM
 */
public class IAVLTreeDemo {
    public static void main(String[] args) {
        //int a[] = {4,3,6,5,7,8};
        //int a[] = {10,12, 8, 9, 7, 6};
        int a[] = {10,11,7,6,8,9};
        AVLTree avlTree = new AVLTree();
        //测试计算树的高度
        for (int i = 0; i <a.length ; i++) {
            avlTree.add(new Nody1(a[i]));
        }
        System.out.println("infix order after rotate");
        avlTree.infixOrder();
        System.out.println("height root tree"+avlTree.getRoot().hejght());
        System.out.println("height left tree"+avlTree.getRoot().leftHeight());
        System.out.println("height right tree"+avlTree.getRoot().rightHeight());
        System.out.println(avlTree.getRoot().left.left.left);
    }
}

class AVLTree {
    private Nody1 root;

    public Nody1 getRoot() {
        return root;
    }

    //删除右子树最小值，并返回该value
    public int delRightTreeMin(Nody1 nody) {
        Nody1 target = nody;
        while (target.left != null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    //删除节点方法
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //寻找删除的结点
            Nody1 targetNode = search(value);
            //如果为空
            if (targetNode == null) {
                return;
            }
            //如果只有一个节点,也可以通过父节点进行判断
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            Nody1 parent = searchParent(value);
            //如果删除的是叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                //判断椰子节点是父节点的左节点还是右节点
                if (parent.left == targetNode) {
                    parent.left = null;
                } else if (parent.right == targetNode) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {//删除的结点有2个子树
                int min = delRightTreeMin(targetNode.right);
                targetNode.value = min;
            } else {//只有一种子树的情况
                if (targetNode.left != null) {
                    if (parent != null) {
                        if (parent.left == targetNode) {
                            parent.left = targetNode.left;
                        } else if (parent.right == targetNode) {
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else if (targetNode.right != null) {
                    if (parent != null) {
                        if (parent.left == targetNode) {
                            parent.left = targetNode.right;
                        } else if (parent.right == targetNode) {
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }

                }
            }
        }
    }

    //添加节点的方法
    public void add(Nody1 nody) {
        //根为空
        if (root == null) {
            root = nody;
        } else {
            root.add(nody);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root == null) {
            System.out.println("root is null can not ");
        } else {
            root.infixOrder();
        }
    }

    //查找结点
    public Nody1 search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找父节点
    public Nody1 searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }
}



    /**
     * 就是node，为避免与同包中node类冲突，故而取名nody
     */
    class Nody1 {
        int value;
        Nody1 left;
        Nody1 right;
        //right rotate
        public void rightRotate(){
            Nody1 nody1 = new Nody1(value);
            nody1.left=left.right;
            nody1.right=right;
            value=left.value;
            left=left.left;
            right=nody1;
        }
        //leftrotate
        public void leftRotate(){
            //tmp node
            Nody1 nody1 = new Nody1(value);
            nody1.left=left;
            nody1.right=right.left;
            //root node
            value=right.value;
            right=right.right;
            left=nody1;
        }

        //该节点为根节点的高度
        public int hejght() {
            return Math.max(left == null ? 0 : left.hejght(), right == null ? 0 : right.hejght()) + 1;
        }

        //左子树高度
        public int leftHeight() {
            if (left == null) {
                return 0;
            }
            return left.hejght();
        }

        //右子树高度
        public int rightHeight() {
            if (right == null) {
                return 0;
            }
            return right.hejght();
        }

        //查找父节点
        public Nody1 searchParent(int value) {
            if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
                return this;
            } else {
                if (value < this.value && this.left != null) {
                    return this.left.searchParent(value);
                } else if (value >= this.value && this.right != null) {
                    return this.right.searchParent(value);
                } else {
                    return null;
                }
            }
        }

        //查找节点
        public Nody1 search(int value) {
            //就是
            if (this.value == value) {
                return this;
            } else if (value < this.value) {//值比当前节点小
                if (this.left == null) {//如果左边没有
                    return null;
                } else {//左边只存在
                    return this.left.search(value);
                }
            } else {//值比当前节点大于等于
                if (this.right == null) {
                    return null;
                } else {
                    return this.right.search(value);
                }
            }
        }

        //添加节点方法
        public void add(Nody1 nody) {
            //为空
            if (nody == null) {
                return;
            }
            //小于当前节点的值
            if (nody.value < this.value) {
                if (this.left == null) {
                    this.left = nody;
                } else {
                    this.left.add(nody);
                }

            } else {//大于等于情况
                if (this.right == null) {
                    this.right = nody;
                } else {
                    this.right.add(nody);
                }
            }
            //left rotate
            if(rightHeight()-leftHeight()>1){
                if(right!=null&&right.leftHeight()>right.rightHeight()){
                    right.rightRotate();
                    leftRotate();
                }else {
                    leftRotate();
                    return;
                }

            }
            //right rotate
            if(leftHeight()-rightHeight()>1){
                if(left!=null&&left.rightHeight()>left.leftHeight()){
                    left.leftRotate();
                    rightRotate();
                }else {
                    rightRotate();
                }
            }
        }

        //中序遍历
        public void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.println(this);
            if (this.right != null) {
                this.right.infixOrder();
            }
        }

        public Nody1(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Nody{" +
                    "value=" + value +
                    '}';
        }
    }