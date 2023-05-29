package f_sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 功能
 *
 * @author caojianbang
 * @date 27.9.22 12:43 AM
 */
public class EQuickSort {
    public static void main(String[] args) {
//        int[] arrays = new int[]{-9, 78, 0, 23, 89, 70};
//        sort(arrays, 0, arrays.length - 1);
        //创建个80000个数
        int arr[] = new int[100000000];
        for (int i=0;i<100000000;i++){
            arr[i]= (int) (Math.random()*100000000);
        }
        //计时
        Date d1=new Date() ;
        SimpleDateFormat sf= new SimpleDateFormat( "yyyy-MM-dd hh-mm-ss");
        System.out.println("排序前"+sf.format(d1));

      sort(arr,0,arr.length-1);

        Date d2=new Date() ;
        System.out.println("排序前"+sf.format(d2));

    }

    public static void sort(int[] a, int left, int right) {
        //左边右边，中轴，临时变量
        int l = left;
        int r = right;
        int p = a[(l + r) / 2];
        int t = 0;
        while (l < r) {
            //从左边找大于中间
            while (a[l] < p) {
                l++;
            }
            //从右边找小于中间
            while (a[r] > p) {
                r--;
            }
            //循环退出条件
            if (l >= r) {
                break;
            }
            //交换
            t = a[l];
            a[l] = a[r];
            a[r] = t;
            //防止死循环
            if (a[l] == p) {
                r--;
            }
            if (a[r] == p) {
                l++;
            }
        }
        //防止栈溢出
        if(l==r){
            l++;
            r--;
        }

        //左递归
        if(left<r){
            sort(a,left,r);
        }
        //右递归
        if(l<right){
            sort(a,l,right);
        }
    }

}


