package e_recursion;

/**
 * 功能：递归
 *
 * @author caojianbang
 * @date 19.9.22 2:25 PM
 */
public class AppTest {
    public static void main(String[] args) {
        //画地图
        int map[][]=new int[8][7];
        for (int i = 0; i <8 ; i++) {//画左右
            map[i][0]=1;
            map[i][6]=1;
        }
        for (int i = 0; i < 7; i++) {//画上下
            map[0][i]=1;
            map[7][i]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        //遍历整个图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        //递归
        getRoute(map,1,1);
        System.out.println("-------------------------");
        //遍历
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    //回溯方法  0 1 2走过
    public static boolean getRoute(int[][] map,int i,int j){
        if(map[6][5]==2){//到目的地，结束
        return true;
        }else {//递归
            if(map[i][j]==0){//可以走的点
                map[i][j]=2;//走过
                if(getRoute(map,i+1,j)){//向下
                    return true;
                }else if(getRoute(map,i,j+1)){//右
                    return true;
                }else if(getRoute(map,i-1,j)){//上
                    return true;
                }else if(getRoute(map,i,j-1)){//左
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else {//不可以走的点
                return false;
            }
        }

    }
}
