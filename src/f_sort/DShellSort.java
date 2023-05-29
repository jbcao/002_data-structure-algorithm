package f_sort;

import java.util.Arrays;

/**
 * 功能:希尔排序
 *
 * @author caojianbang
 * @date 25.9.22 12:17 AM
 */
public class DShellSort {
    public static void main(String[] args) {
        int a[] = {8,9,1,7,2,3,5,4,6,0};
        shellSort2(a);
        System.out.println("后"+Arrays.toString(a));

    }
    public static void shellSort(int[] a){
//交换法
        int tmp=0;
        //躺输
        for (int gap=a.length/2;gap>0;gap/=2){
            //待插入
            for (int i = gap; i <a.length ; i++) {
                //对比
                for (int j = i-gap; j >=0; j-=gap) {
                    if(a[j]>a[j+gap]){
                        tmp = a[j];
                        a[j]=a[j+gap];
                        a[j+gap]=tmp;
                    }

                }

            }

        }






        /*
        //逐步推导
        //第一轮 ,分为5组，步长即5
        //每一组开始
        int tmp=0;
        for (int i = 5; i <a.length ; i++) {
            //对比的,从后往前，是插入排序的思想，只不过这里是交换法
            for (int j = i-5; j >=0 ; j-=5) {
                if(a[j]>a[j+5]){
//交换
                    tmp=a[j];
                    a[j]=a[j+5];
                    a[j+5]=tmp;
                }
            }
        }
        System.out.println("第一轮"+Arrays.toString(a));
        //第二
        for (int i = 2; i <a.length ; i++) {
            //对比的,从后往前，是插入排序的思想，只不过这里是交换法
            for (int j = i-2; j >=0 ; j-=2) {
                if(a[j]>a[j+2]){
//交换
                    tmp=a[j];
                    a[j]=a[j+2];
                    a[j+2]=tmp;
                }
            }
        }
        System.out.println("第二轮"+Arrays.toString(a));

        //第三
        for (int i = 1; i <a.length ; i++) {
            //对比的,从后往前，是插入排序的思想，只不过这里是交换法
            for (int j = i-1; j >=0 ; j-=1) {
                if(a[j]>a[j+1]){
//交换
                    tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                }
            }
        }
        System.out.println("第一轮"+Arrays.toString(a));*/
    }

    public static void shellSort2(int[] a){

        //躺输
        for (int gap=a.length/2;gap>0;gap/=2){
            //待插入
            for (int i = gap; i <a.length ; i++) {
                //使用移位法
               int j=i;
               int tmp = a[i];
               while(j-gap>=0&&a[j-gap]>tmp){
                   a[j]=a[j-gap];
                   j-=gap;
               }
               //插入
                a[j]=tmp;
            }

        }
    }
}
