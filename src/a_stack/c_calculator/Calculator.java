package a_stack.c_calculator;

/**
 * 功能
 *
 * @author caojianbang
 * @date 9.9.22 7:59 PM
 */
public class Calculator {
    public static void main(String[] args) {
        String str  = "2+3*9+90+89";
        /**
         * 遍历字符串
         * 判断是字符还是数字
         * 数字放在数字栈中，字符放在字符栈
         * 字符栈：如果是空栈，直接入栈，如果运算符栈已经有其他预算符号，要比较优先级，新的小于等于之前的，将原来的出栈，数字栈中的数字出栈，运算后的结果放入数字栈，，新运算符入栈；
         *        如果新的优先级大于之前的，则直接入栈
         */
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack symbolStack = new ArrayStack(10);
        int temp1 = 0; //用于计算的数
        int temp2 = 0;
        int result = 0;  //运算结果
        int symbolChar=0;   //运算符
        int length = str.length();
        String values="";  //多位数字的拼接
        for (int i = 0; i < length; i++) {
            //遍历每个字符
            char c= str.charAt(i);
            //判断是否字符
            if (symbolStack.isOper(c)){
                //是否空栈
                if(!symbolStack.isEmpty()){
                    if(symbolStack.priority(c)<=symbolStack.priority(symbolStack.peek())){
                        /**
                         * 从数字栈取出两个数，从符号栈再取出一个符号进行运算，运算完的结果寻如数字栈
                         */
                        temp1=numStack.pop();
                        temp2=numStack.pop();
                        symbolChar=symbolStack.pop();
                        result=numStack.calcalate(temp1,temp2,symbolChar);
                        numStack.push(result);
                        symbolStack.push(c);
                    }else {
                        //新运算符大于原来的，直接放入
                        symbolStack.push(c);
                    }
                }else {
                    //空栈，直接存入
                    symbolStack.push(c);
                }
            }else {
                //不是字符
                values+=c;
                if(i==length-1){ //最后一个字符是数字，直接入栈
                    numStack.push(Integer.parseInt(values));
                }else {//不是最后一个 例如： 336+89  如果后一个是运算符，则存入栈，如果不是，则继续循环
                    char data =str.substring(i+1,i+2).charAt(0);
                    if(symbolStack.isOper(data)){
                        numStack.push(Integer.parseInt(values));
                        values="";
                    }
                }
            }
        }
        //循环进行计算
        while (true){
            if(symbolStack.isEmpty()){
                break;
            }
            temp1 = numStack.pop();
            temp2 = numStack.pop();
            symbolChar =symbolStack.pop();
            result = numStack.calcalate(temp1,temp2,symbolChar);
            numStack.push(result);
        }
        System.out.println("结果是"+numStack.pop());
    }
}
