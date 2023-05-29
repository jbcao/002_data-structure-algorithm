package g_search;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能
 *
 * @author caojianbang
 * @date 12.10.22 9:43 AM
 */
public class BBinarySearch {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4,4,4,4, 5666, 7888};
        System.out.println(binarySearch2(a, 0, a.length, 4));
    }

    public static int binarySearch(int[] a, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        if (left > right) {//没找到
            return -1;
        }
        if (findVal > a[mid]) {//右递归
            return binarySearch(a, mid + 1, right, findVal);
        } else if (findVal < a[mid]) {//左递归
            return binarySearch(a, left, mid - 1, findVal);
        } else {//找到
            return mid;
        }
    }

    //有相同的值，一同存入到
    public static List<Integer> binarySearch2(int[] a, int left, int right, int findVal) {
        List resIndexList = new ArrayList<Integer>();
        int mid = (left + right) / 2;
        if (left > right) {//没找到
            return resIndexList;
        }
        if (findVal > a[mid]) {//右递归
            return binarySearch2(a, mid + 1, right, findVal);
        } else if (findVal < a[mid]) {//左递归
            return binarySearch2(a, left, mid - 1, findVal);
        } else {//找到,先不向左遍历，再向右遍历
            //左边遍历
            int tmp = mid - 1;
            while (true) {
                if (tmp < 0 || a[tmp] != a[mid]) {
                    break;
                }
                //存入集合
                resIndexList.add(tmp);
                tmp--;
            }
            //中间值存入集合
            resIndexList.add(mid);
            //右边遍历
            tmp = mid + 1;
            while (true) {
                if (tmp > a.length - 1 || a[tmp] != a[mid]) {
                    break;
                }
                //存入集合
                resIndexList.add(tmp);
                tmp++;
            }
            return resIndexList;
        }
    }
}
