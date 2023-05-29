package g_search;

/**
 * 功能现行查找
 *
 * @author caojianbang
 * @date 11.10.22 11:27 AM
 */
public class ASeqSearch {
    public static void main(String[] args) {
        int a[] = {4,6,7,8,4,77,57,67,78};
        int index=seqSearch(a,57);
        System.out.println(index);

    }
    public static int seqSearch(int[] arr ,int value){
        for (int i = 0; i < arr.length; i++) {
            if(value==arr[i]){
                return i;
            }
        }
        return -1;
    }
}
