package g_search;

import java.util.Arrays;

/**
 * 功能
 *
 * @author caojianbang
 * @date 24.10.22 6:36 PM
 */
public class DFibonacciSearch {
    public static int maxSize=20;
    public static void main(String[] args) {
        int a[]= {1,2,44,56,6767,6768};
        System.out.println("index"+" "+fibSearch(a,3));

    }
    //斐波那契数列
    public static int[] fib(){
        int f[] = new int[maxSize];
        f[0]=1;
        f[1]=1;
        for (int i = 2; i <f.length ; i++) {
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }
    //斐波那契查找 非递归
    public static int fibSearch(int[] a,int findVal){
        int left=0;
        int right = a.length-1;
        int k=0;//斐波那契分割数值的下标
        int f[] = fib();

        //保证斐波那契数列大于数组个数
        while(a.length>f[k]-1){
            k++;
        }

        //创建临时数组
        int temp[] = Arrays.copyOf(a,f[k]);
        //临时数组填充
        for (int i = right+1; i <f[k]-1 ; i++) {
            temp[i]=a[right];
        }

        //查找
        while(left<=right){//左边小于右边
            int mid= left+f[k-1]-1;
            if(findVal<temp[mid]){//到左边查找
                right=mid-1;
                k--;
            }else if(findVal>temp[mid]){//到右边查找
                left=mid+1;
                k-=2;
            }else {//找到
                if(mid<right){
                    return mid;
                }else {
                    return right;
                }
            }

        }
        return -1;
        
    }
}
