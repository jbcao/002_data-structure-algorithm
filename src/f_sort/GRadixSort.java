package f_sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能
 *
 * @author caojianbang
 * @date 29.9.22 11:16 PM
 */
public class GRadixSort {
    public static void main(String[] args) {
//        int arr[] = { 53, 3, 542, 748, 14, 214};
//        radixSort(arr);
//        System.out.println(Arrays.toString(arr));
        int arr[] = new int[8000000];
        for (int i=0;i<8000000;i++){
            arr[i]= (int) (Math.random()*8000000);
        }
        //计时
        Date d1=new Date() ;
        SimpleDateFormat sf= new SimpleDateFormat( "yyyy-MM-dd hh-mm-ss");
        System.out.println("排序前"+sf.format(d1));

        radixSort(arr);

        Date d2=new Date() ;
        System.out.println("排序前"+sf.format(d2));
    }
    public static void radixSort(int[] a){
        //求出最大
        int max=a[0];
        for(int i=0;i<a.length;i++){
            if(max<a[i]){
                max=a[i];
            }
        }
        //求出最大数位数
        int maxLength=(max+"").length();
        //桶子
        int[][] bucket = new int[10][a.length];
        //记录每个桶实际存入数据
        int[] bucketElementCounts=new int[10];
        //循环排序
        for (int i = 0,n=1; i <maxLength ; i++,n*=10) {
            //存入桶
            for (int j = 0; j < a.length; j++) {
                //取出对应位的值
                int digitOfElement = a[j]/n%10;
                //存入对应桶子
                bucket[digitOfElement][bucketElementCounts[digitOfElement]]=a[j];
                //桶子里个数增加
                bucketElementCounts[digitOfElement]++;
            }
            //从桶中取出
            int k = 0;
            for (int j = 0; j <bucket.length ; j++) {
                //判断，有元素才遍历
                if (bucketElementCounts[j]!=0){
                    for (int l = 0; l <bucketElementCounts[j] ; l++) {
                        a[k]=bucket[j][l];
                        k++;
                    }
                }
                //要将桶子个数归0
                bucketElementCounts[j]=0;
            }
        }
    }
}
