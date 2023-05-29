package k_algorithm;

/**
 * 功能 汉诺塔问题
 *
 * @author caojianbang
 * @date 2.12.22 6:30 AM
 */
public class BHanoi {
    public static void main(String[] args) {
        hanoi(3, 'A', 'B', 'C');

    }

    public static void hanoi(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("将第1个盘从" + a + "->" + c);
        } else {
            hanoi(num - 1, a, c, b);
            System.out.println("将" + num + "从" + a + "移动到" + c);
            hanoi(num - 1, b, a, c);
        }
    }
}