package c_sparsearray;

/**
 * 功能
 *
 * @author caojianbang
 * @date 16.9.22 2:49 PM
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建二维数组
        //存入数据
        //遍历二维数组
        int chessArray[][] = new int[11][11];
        chessArray[1][5] = 89;
        chessArray[8][6] = 7;
        chessArray[6][1] = 11;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                System.out.print(chessArray[i][j] + "\t");
            }
            System.out.println();
        }
        //获取非0个数
        int sum = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int sparseArray[][] = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;


        //遍历二维数组，往稀疏数组存入值
        int count = 0;//不为0的个数
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }
        //遍历稀疏数组
        for (int i = 0; i <sparseArray.length ; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                System.out.print(sparseArray[i][j]+"\t");
            }
            System.out.println();
        }

        //创建数组
        int chessArrayNew[][]=new int[sparseArray[0][0]][sparseArray[0][1]];
        //遍历稀疏数组，赋值给二维数组
        for (int i = 1; i <sparseArray.length ; i++) {
            chessArrayNew[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }

        //遍历新的二维数组
        for (int i=0;i<chessArrayNew.length;i++){
            for (int j = 0; j <chessArrayNew[i].length ; j++) {
                System.out.print(chessArrayNew[i][j]+"\t");
            }
            System.out.println();
        }

    }
}
