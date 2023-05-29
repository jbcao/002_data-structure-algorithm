package i_tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 功能  堆排序
 *
 * @author caojianbang
 * @date 7.11.22 6:01 PM
 */
public class DHeapSort {
    public static void main(String[] args) {
        //测试堆排序
        int a[] =new int[8000000];

        for (int i=0;i<8000000;i++){
            a[i]= (int) (Math.random()*8000000);
        }

        //计时
        Date d1=new Date() ;
        SimpleDateFormat sf= new SimpleDateFormat( "yyyy-MM-dd hh-mm-ss");
        System.out.println("排序前"+sf.format(d1));
        heapSort(a);
        Date d2=new Date() ;
        System.out.println("排序前"+sf.format(d2));



    }
    //堆排序
    public static void heapSort(int[] a){
        //调整成大顶堆
        for (int i = a.length/2-1; i >=0 ; i--) {
            adjustHeap(a,i,a.length);
        }
        //循环交换与调整大顶堆
        int tmp=0;
        for (int i = a.length-1; i >0 ; i--) {
            tmp=a[0];
            a[0]=a[i];
            a[i]=tmp;
            adjustHeap(a,0,i);
        }

    }

    //调整成堆
    public static void adjustHeap(int[] a,int i,int length){
        //临时值，存放i节点值
        int tmp =a[i];
        //循环调整
        for (int k= 2*i+1; k<length  ;k=2*k+1 ) {

            //判断左右两节点大小
            if(k+1<length&&a[k]<a[k+1]){
                k++;//指向较大的
            }

            //大的子节点和符节点的大小
            if(a[k]>tmp){
                a[i]=a[k];
                i=k;
            }else {
                break;
            }

            //交换
            a[i]=tmp;
        }
    }
}
