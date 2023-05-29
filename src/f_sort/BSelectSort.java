package f_sort;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 功能 :选择排序
 *
 * @author caojianbang
 * @date 24.9.22 3:45 PM
 */
public class BSelectSort {
    public static void main(String[] args) {
//        int[] arr = {101,34,119,1};
//        selectSort(arr);
//测试80000数
        //创建个80000个数
        int arr[] = new int[80000];
        for (int i=0;i<80000;i++){
            arr[i]= (int) (Math.random()*80000);
        }

        //计时
        Date d1=new Date() ;
        SimpleDateFormat sf= new SimpleDateFormat( "yyyy-MM-dd hh-mm-ss");
        System.out.println("排序前"+sf.format(d1));

        selectSort(arr);

        Date d2=new Date() ;
        System.out.println("排序前"+sf.format(d2));

    }
    public static void selectSort(int[] a){
        for (int i = 0; i <a.length-1 ; i++) {//循环趟数
            int minIndex= i;
            int minVal=a[i];
            for (int j = i+1; j <a.length ; j++) {//核心算法
                if(minVal>a[j]){//对比，重置
                    minIndex=j;
                    minVal=a[j];
                }
            }
            //交换
            a[minIndex]=a[i];
            a[i]=minVal;
        }
        //System.out.println(Arrays.toString(a));

        /*
        //逐步推导  101 34 119 1
        //第一轮
        int minIndex=0;
        int minVal=a[0];
        for (int i = 1; i <a.length ; i++) {
            if(minVal>a[i]){
                minIndex=i;
                minVal=a[i];
            }
        }
        //交换
        a[minIndex]=a[0];
        a[0]=minVal;
        //输出
        System.out.println("第一轮："+Arrays.toString(a));

        //第二轮
        minIndex=1;
        minVal=a[1];

        for (int i = 2; i <a.length ; i++) {
            if(minVal>a[i]){
                minIndex=i;
                minVal=a[i];
            }
        }
        //交换
        a[minIndex]=a[1];
        a[1]=minVal;
        //输出
        System.out.println("第一轮："+Arrays.toString(a));

        //第三轮
        minIndex=2;
        minVal=a[2];

        for (int i = 3; i <a.length ; i++) {
            if(minVal>a[i]){
                minIndex=i;
                minVal=a[i];
            }
        }
        //交换
        a[minIndex]=a[2];
        a[2]=minVal;
        //输出
        System.out.println("第一轮："+Arrays.toString(a));
        */
    }
}
