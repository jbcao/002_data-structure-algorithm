package g_search;

/**
 * 功能 插值查找
 *
 * @author caojianbang
 * @date 15.10.22 5:55 PM
 */
public class CInsertValueSearch {
    public static void main(String[] args) {
        int a[]=new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i]=i+1;
        }
        System.out.println(insertValueSearch(a,0,a.length-1,100));

    }
    //返回的是元素索引
    public static int insertValueSearch(int[] a,int left,int right,int findVal){
        //递归退出条件
        if(left>right||findVal<a[left]||findVal>a[right]){//       后面两个条件彼此，防止越界
            return -1;
        }
        int mid=left+(right-left)*(findVal-a[left])/(a[right]-a[left]);
        //判断，然后递归
        if(findVal>a[mid]){//向右递归
            return insertValueSearch(a,mid+1,right,findVal);
        }else if(findVal<a[mid]){//左递归
            return insertValueSearch(a,left,mid-1,findVal);
        }else {
            return mid;
        }
    }
}
