package f_sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 功能
 *
 * @author caojianbang
 * @date 29.9.22 5:25 PM
 */
public class FMergeSort {
    public static void main(String[] args) {
       // int[] arr = {8,4,5,7,1,3,6,2};


        //System.out.println(Arrays.toString(arr));
        int arr[] = new int[8000000];
        for (int i=0;i<8000000;i++){
            arr[i]= (int) (Math.random()*8000000);
        }
        int[] temp = new int[arr.length];
        //计时
        Date d1=new Date() ;
        SimpleDateFormat sf= new SimpleDateFormat( "yyyy-MM-dd hh-mm-ss");
        System.out.println("排序前"+sf.format(d1));

        mergeSort(arr,0,arr.length-1,temp);

        Date d2=new Date() ;
        System.out.println("排序前"+sf.format(d2));
    }
    //归并排序
    public static void mergeSort(int[] arr ,int left ,int rignt,int[] temp){

        if(left<rignt){
            int mid=(left+rignt)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,rignt,temp);
            merge(arr,left,mid,rignt,temp);
        }

    }


    //合的方法
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左边数组出事索引
        int j = mid + 1;//右边初始索引
        int t = 0;//临时数组初始索引
        //两个数组按从小到大顺序存入temp
        while (i <= mid && j <= right) {
            //小的先存入
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        //将其中一个剩余的依次存入temp
        //如果左边有剩余
        while (i <= mid) {
            //按从小到大顺序存入
            temp[t] = arr[i];
            i++;
            t++;

        }
        //如果右边有剩余
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }
        //temp存入arr
        t = 0;//tmp指针移动到最前
        int arrIndex = left;//arr头指针
        while (arrIndex <= right) {
            arr[arrIndex] = temp[t];
            arrIndex++;
            t++;
        }
    }
}
