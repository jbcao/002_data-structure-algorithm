package k_algorithm;

/**
 * 功能  暴力匹配算法
 *
 * @author caojianbang
 * @date 5.12.22 1:30 AM
 */
public class DViolenceMatch {
    public static void main(String[] args) {

    }
    public static int violenceMatch(String s1,String s2){
        char c1[]=s1.toCharArray();
        char c2[]=s2.toCharArray();
        int i=0;
        int j=0;
        while(i<c1.length&&j<c2.length){
            if(c1[i]==c2[j]){
                i++;
                j++;
            }else {
                i=i-j+1;
                j=0;
            }
        }
        if(j==c2.length){
            return i-j;
        }else {
            return -1;
        }
    }
}
