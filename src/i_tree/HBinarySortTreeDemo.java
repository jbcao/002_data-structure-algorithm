package i_tree;

/**
 * 功能 二叉排序树
 *
 * @author caojianbang
 * @date 23.11.22 5:29 AM
 */
public class HBinarySortTreeDemo {
    public static void main(String[] args) {
        int[] a = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < a.length; i++) {
            binarySortTree.add(new Nody(a[i]));
        }
        binarySortTree.infixOrder();
        //测试查找结点
        System.out.println(binarySortTree.search(7));
        //测试查找父节点
        System.out.println(binarySortTree.searchParent(3));
        //测试删除方法
        System.out.println("del  node");
        binarySortTree.delNode(12);
        binarySortTree.infixOrder();

    }
}

class BinarySortTree {
    private Nody root;

    //删除右子树最小值，并返回该value
    public int delRightTreeMin(Nody nody) {
        Nody target = nody;
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
            Nody targetNode = search(value);
            //如果为空
            if (targetNode == null) {
                return;
            }
            //如果只有一个节点,也可以通过父节点进行判断
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            Nody parent = searchParent(value);
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
    public void add(Nody nody) {
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
    public Nody search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找父节点
    public Nody searchParent(int value) {
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
class Nody {
    int value;
    Nody left;
    Nody right;

    //查找父节点
    public Nody searchParent(int value) {
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
    public Nody search(int value) {
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
    public void add(Nody nody) {
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

    public Nody(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Nody{" +
                "value=" + value +
                '}';
    }
}