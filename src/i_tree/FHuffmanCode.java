package i_tree;

import java.io.*;
import java.util.*;
import java.util.List;

/**
 * 功能:赫夫曼编码
 *
 * @author caojianbang
 * @date 11.11.22 8:26 PM
 */
public class FHuffmanCode {

    public static void main(String[] args) {
        String str = "i like like like java do you like a javajjjjjjaaaaaaaaj";
        //String str = "ja";
        byte bytes[] = str.getBytes();
        //bianma
        byte[] h1 = huffmanZip(bytes);
        //解码
        byte b[] = decode(huffmanCodes, h1);
        System.out.println("解码后结果===" + new String(b));
        //文件压缩测试
        //zipFile("/Users/apple/Desktop/a.jpeg", "/Users/apple/Desktop/b.zip");
        //文件解压测试


        //unZipFile("/Users/apple/Desktop/b.zip","/Users/apple/Desktop/a-new.jpeg");

    }

    //文件解压
    public static void unZipFile(String zipFile, String dstFile) {
        InputStream is = null;
        InputStream ois = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(zipFile);
            ois = new ObjectInputStream(is);
            //对象流读对象
            byte huffmanBytes[] = (byte[]) ((ObjectInputStream) ois).readObject();
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ((ObjectInputStream) ois).readObject();
            byte[] decode = decode(huffmanCodes, huffmanBytes);
            os = new FileOutputStream(dstFile);
            os.write(decode);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("解压完成了~~~");

        }


    }

    //文件压缩
    public static void zipFile(String srcFile, String dstFile) {
        InputStream is = null;
        OutputStream os = null;
        OutputStream oos = null;
        try {
            is = new FileInputStream(srcFile);
            byte b[] = new byte[is.available()];
            is.read(b);
            byte huffmanBytes[] = huffmanZip(b);
            os = new FileOutputStream(dstFile);
            oos = new ObjectOutputStream(os);
            ((ObjectOutputStream) oos).writeObject(huffmanBytes);
            ((ObjectOutputStream) oos).writeObject(huffmanCodes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("文件压缩完毕~~~");
        }

    }

    //解码
    public static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        //1,将得到的赫夫曼编码后的字节码转成字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {//最后一个是记录0个数的，要单独处理
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, huffmanBytes[i]));
        }
        System.out.println("需要将解码的二进制是" + stringBuilder);
        //2，将赫夫曼编码的key和value进行调换
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry :
                huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //3.循环遍历字符串，寻找匹配的字节
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            //定义三个变量
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                String str = stringBuilder.substring(i, i + count);
                b = map.get(str);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        //4.list into  byte array
        byte b[] = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            try {
                b[i] = list.get(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return b;
    }

    public static String byteToBitString(boolean flag, byte b) {
        System.out.println("需要转为二进制的byte是" + b);
        //转为int
        int tmp = b;
        //负数截断  整数左位或  最后一个不操作
        if (flag) {
            tmp |= 256;
        }
        //转为二进制补码
        String str = Integer.toBinaryString(tmp);
        System.out.println(str);
        //如果是负数，要进行截断
        String tmp1 = "";
        if (flag) {
            return str.substring(str.length() - 8);

        } else if (num > 0) {//正数或0
            for (int j = 1; j <= num; j++) {
                tmp1 = tmp1 + "0";
            }
            str=tmp1+str;
            return str;
        } else if (b < 0) {//负数
            return str.substring(str.length() - 8);
        }
        return str;
    }


    public static byte[] huffmanZip(byte[] bytes) {
        System.out.println("需要编码的字符串为" + new String(bytes));
        System.out.println("需要编码的byte为" + Arrays.toString(bytes));
        //获得list集合
        List<Nodo> nodes = getNodes(bytes);
        //创建赫夫曼树
        Nodo root = getHuffmanTree(nodes);
        //赫夫曼编码
        Map<Byte, String> codes = getCodes(root);
        //生成赫夫曼字节数组
        byte[] zip = zip(bytes, codes);
        System.out.println("编码过后的byte数组" + Arrays.toString(zip));
        return zip;
    }

    //工具类：是否全0,全0 true,
    public static boolean all0(String str) {
        return !str.contains("1");
    }
    //保留最后有多少个0
    public static int num;

    //将原有字节数组 转换成赫夫曼编码编码字符换，在转为压缩后的字节数组
    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //将原字节数组转陈赫夫曼编码
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        //
        int len = (stringBuilder.length() + 7) / 8;
        byte huffmanCodeBytes[] = new byte[len];//最后一个用于记录最后几个位前面0的个数
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String str;
            if (i + 8 > stringBuilder.length()) {//最后几位,要得到0的个数
                str = stringBuilder.substring(i);
                System.out.println("最后的几个二进制" + str);
                //int num = 0;
                if (str.startsWith("0")) {
                    //全0
                    if (all0(str)) {
                        num = str.length() - 1;
                    }
                    //f非全0
                    if (!all0(str)) {
                        for (int j = 0; j < str.length(); j++) {
                            String tmp = str.substring(j, j + 1);
                            if (tmp.equals("1")) {//前面是0情况，
                                num = j;
                                break;
                            }
                        }
                    }
                }
                System.out.println("0的数量" + num);
            } else {
                str = stringBuilder.substring(i, i + 8);
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(str, 2);
            index++;
        }
        System.out.println("赫夫曼编码后的字节码为==" + Arrays.toString(huffmanCodeBytes));
        return huffmanCodeBytes;
    }

    //为了方便调用，重载方法
    public static Map<Byte, String> getCodes(Nodo root) {
        if (root == null) {
            System.out.println("tree is null");
            return null;
        }
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        System.out.println("生成的赫夫曼编码" + huffmanCodes);
        return huffmanCodes;
    }

    //map存放赫夫曼编码
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    //可变字符序列，存放拼接路径
    static StringBuilder stringBuilder = new StringBuilder();

    //获得赫夫曼编码
    public static void getCodes(Nodo node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node != null) {//
            if (node.data == null) {//feiyezi
                getCodes(node.left, "0", stringBuilder1);
                getCodes(node.right, "1", stringBuilder1);
            } else {
                huffmanCodes.put(node.data, stringBuilder1.toString());
            }
        }
    }

    //前序遍历
    public static void preOrder(Nodo root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("树为空");
        }

    }

    //创建赫夫曼树
    public static Nodo getHuffmanTree(List<Nodo> nodos) {
        while (nodos.size() > 1) {
            //排序
            Collections.sort(nodos);
            //取出最小的两颗树
            Nodo leftNode = nodos.get(0);
            Nodo rightNode = nodos.get(1);
            //构建树
            Nodo parent = new Nodo(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodos.remove(0);
            nodos.remove(0);
            //新树加入
            nodos.add(parent);
        }
        return nodos.get(0);
    }

    //接收字节数组，返回list,其中元素是Nodo类型
    public static List<Nodo> getNodes(byte[] bytes) {
        //创建ArrayList
        List<Nodo> nodos = new ArrayList<Nodo>();

        //使用map统计
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes
                ) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        //创建节点类，并存入list
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()
                ) {
            nodos.add(new Nodo(entry.getKey(), entry.getValue()));
        }
        return nodos;
    }
}

class Nodo implements Comparable<Nodo> {
    Byte data;//存放字符本身
    int weight;//权值，出现的次数
    Nodo left;
    Nodo right;

    public Nodo(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(Nodo o) {
        return this.weight - o.weight;
    }
}