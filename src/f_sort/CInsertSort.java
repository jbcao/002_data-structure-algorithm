package f_sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 功能:插入排序
 *
 * @author caojianbang
 * @date 24.9.22 10:37 PM
 */
public class CInsertSort {
    public static void main(String[] args) {
        //int[] a = {101, 34, 119, 1};
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

        insertSort(arr);

        Date d2=new Date() ;
        System.out.println("排序前"+sf.format(d2));
    }

    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int insertVal = a[i];//待插入
            int insertIndex = i - 1;//待比较
            //循环比较
            while (insertIndex >= 0 && a[insertIndex] > insertVal) {
                //比较的值后移
                a[insertIndex + 1] = a[insertIndex];
                //索引前移
                insertIndex--;
            }

            //插入
            if (insertIndex + 1 != i) {
                a[insertIndex + 1] = insertVal;
            }

        }

/*
        //逐步推导{101,34,119,1};
        //第一轮
        int insertVal = a[1];
        int insertIndex = 1 - 1;
        while (insertIndex >= 0 && insertVal < a[insertIndex]) {
            //对比的元素后移动
            a[insertIndex + 1] = a[insertIndex]; //{101,101,119,1}

            //对比索引-1
            insertIndex--;
        }
        a[insertIndex + 1] = insertVal;
        System.out.println("第一轮" + Arrays.toString(a));

        //第2轮
        insertVal = a[2];
        insertIndex = 2 - 1;
        while (insertIndex >= 0 && insertVal < a[insertIndex]) {
            //对比的元素后移动
            a[insertIndex + 1] = a[insertIndex]; //{101,101,119,1}

            //对比索引-1
            insertIndex--;
        }
        a[insertIndex + 1] = insertVal;
        System.out.println("第一轮" + Arrays.toString(a));

        //第3轮
        insertVal = a[3];
        insertIndex = 3 - 1;
        while (insertIndex >= 0 && insertVal < a[insertIndex]) {
            //对比的元素后移动
            a[insertIndex + 1] = a[insertIndex]; //{101,101,119,1}

            //对比索引-1
            insertIndex--;
        }
        a[insertIndex + 1] = insertVal;
        System.out.println("第一轮" + Arrays.toString(a));
        */
    }
//互信算法的循环次数比while多所以
    public static void insertSort2(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int insertVal = a[i];//待插入
            int insertIndex = i - 1;//待比较
            //循环比较
            for (int j = i - 1; j >=0; j--) {
                if (insertIndex >= 0 && a[insertIndex] > insertVal) {
                    //比较的值后移
                    a[insertIndex + 1] = a[insertIndex];
                    //索引前移
                    insertIndex--;
                }
            }

            //插入
            if (insertIndex + 1 != i) {
                a[insertIndex + 1] = insertVal;
            }

        }
    }
}
