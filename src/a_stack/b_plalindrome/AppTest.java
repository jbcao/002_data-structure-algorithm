package a_stack.b_plalindrome;

import a_stack.ArrayStack;

/**
 * 功能 回文
 *
 * @author caojianbang
 * @date 8.9.22 3:52 PM
 */
public class AppTest {
    public static void main(String[] args) {
        System.out.println(detection("aba"));

    }
    public static boolean detection(String words){
        /**
         * 入栈
         * 出栈
         * 对比
         */
        int length =words.length();
        ArrayStack arrayStack = new ArrayStack(10);

        for (int i=0;i<words.length();i++){
            arrayStack.push(words.charAt(i));
        }
        //遍历一下里面数据
        arrayStack.list();
        //出栈
        String newStr ="";
        for (int i = 0; i < length;i++) {
            if(!arrayStack.isEmpty()){
                char pop = (char) arrayStack.pop();
                newStr+=pop;
            }
        }
        //对比
        if(!newStr.equals(words)){
            return false;
        }
return true;
    }
}
