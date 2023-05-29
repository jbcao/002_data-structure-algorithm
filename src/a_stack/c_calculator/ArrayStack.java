package a_stack.c_calculator;

/**
 * 功能:数组实现栈
 *
 * @author caojianbang
 * @date 8.9.22 12:25 AM
 */
public class ArrayStack {
    //用什么实现
    private int[] stack;
    //规模
    private int maxStack;
    //栈顶，默认值为-1，
    private int top = -1;

    //构造函数初始化要给规模
    public ArrayStack(int maxStack) {
        this.maxStack = maxStack;
        this.stack = new int[maxStack];
    }

    /**
     * 入栈
     * 出栈
     * 判满
     * 判空
     * 遍历
     * 数据大小
     */
    //满
    public boolean isFull() {
        return top == (maxStack - 1);
    }

    //空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("满了。。。");
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("isempty");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历
    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("isempry..");
        }
        for (int i = 0; i < stack.length; i++) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    /**
     * 查看栈大小
     * 查看栈顶
     * 判断是否运算符
     * 优先级
     * 两个数字计算
     */
    //查看栈大小，数组大小，不是元素个数
    public int length() {
        return this.stack.length;
    }

    //栈顶
    public int peek() {
        return stack[top];
    }

    //判断运算符
    public boolean isOper(char v) {
        return v == '+' || v == '-' || v == '*' || v == '/';
    }

    //优先级
    public int priority(int v) {
        if (v == '*' || v == '/') {
            return 1;
        } else if (v == '+' || v == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //计算
    public int calcalate(int n1, int n2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = n1 + n2;
                break;
            case '*':
                res = n1 * n2;
                break;
            case '-':
                res = n2 - n1;
                break;
            case '/':
                res = n2 / n1;
                break;
            default:
                break;
        }
        return res;
    }
}
