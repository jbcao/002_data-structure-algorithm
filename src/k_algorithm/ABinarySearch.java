package k_algorithm;

/**
 * 功能 二分查找 非递归
 *
 * @author caojianbang
 * @date 2.12.22 1:42 AM
 */
public class ABinarySearch {
    public static void main(String[] args) {
        int a[] = {1,3,5,7,44,89,100};
        System.out.println("index="+binarySearch(a,5));

    }
    public static int binarySearch(int a[],int target){
        int left=0;
        int right=a.length-1;

        while(left<=right){
            int mid=(left+right)/2;
            if(a[mid]<target){
                left=mid+1;
            }else if(a[mid]>target){
                right=mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
