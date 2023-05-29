package i_tree;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

/**
 * 功能
 *
 * @author caojianbang
 * @date 1.11.22 1:31 AM
 */
public class Test {
    Emp e3;
   public String s;

    public void f() {
        System.out.println(s);
        for (int i = 0; i < 2; i++) {
            System.out.println(i);
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(i);
        }
    }

    public void f2() {
        int s;
        s = 0;
        System.out.println(s);


    }

    public static void main(String[] args) {
       // Test t = new Test();
        //t.f();
        System.out.println(Integer.parseInt("000010",2));
        System.out.println(Integer.toBinaryString(-86));
        Emp emp = new Emp(1,"jj");
        Emp emp1 = new Emp(1,"jj");
        Emp emp2[] = new Emp[3];
        emp2[1]=emp;
        emp2[2]=emp1;
        System.out.println(Arrays.toString(emp2));

    }
}

class Emp {
    private int id;
    private String name;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}