package f_sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 功能：冒泡排序
 *
 * @author caojianbang
 * @date 24.9.22 2:59 PM
 */
public class ABubbleSort {
    public static void main(String[] args) {
        //int arr[] = {3,9,-1,10,20};
        //System.out.println("原数组"+Arrays.toString(arr));
        //bubbleSort(arr);

        //创建个80000个数
        int arr[] = new int[80000];
        for (int i=0;i<80000;i++){
            arr[i]= (int) (Math.random()*80000);
        }

        //计时
        Date d1=new Date() ;
        SimpleDateFormat sf= new SimpleDateFormat( "yyyy-MM-dd hh-mm-ss");
        System.out.println("排序前"+sf.format(d1));

        bubbleSort(arr);

        Date d2=new Date() ;
        System.out.println("排序前"+sf.format(d2));






    }
    public static void bubbleSort(int[] arr){
        int tmp=0;
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
        //System.out.println("排序后"+Arrays.toString(arr));

/*
        //过程
        //第一轮
        for (int i = 0; i <arr.length-1; i++) {
            if (arr[i]>arr[i+1]){
                //交换
                tmp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=tmp;
            }
        }
        System.out.println("第1轮"+Arrays.toString(arr));
        //第二轮
        for (int i = 0; i <arr.length-1-1; i++) {
            if (arr[i]>arr[i+1]){
                //交换
                tmp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=tmp;
            }
        }
        System.out.println("第2轮"+Arrays.toString(arr));
        //第三轮
        for (int i = 0; i <arr.length-1-2; i++) {
            if (arr[i]>arr[i+1]){
                //交换
                tmp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=tmp;
            }
        }
        System.out.println("第3轮"+Arrays.toString(arr));
        //第四轮
        for (int i = 0; i <arr.length-1-3; i++) {
            if (arr[i]>arr[i+1]){
                //交换
                tmp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=tmp;
            }
        }
        System.out.println("第4轮"+Arrays.toString(arr));
        */

    }
}
