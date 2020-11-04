package fun.hijklmn.virtualMachine;

import java.util.HashSet;
import java.util.Set;

public class RuntimeConstantPoolOOM {

    // -Xms4M -Xmx4M  设置Java对的空间大小

    // 从Java7开始，原本放在永久代的字符串常量池移到了Java对之中。

    public static void main1(String[] args) {

        short i = 0;

        try {
            Set<String> strSet = new HashSet<>();

            while (true) {

                strSet.add(String.valueOf(i++).intern());

            }

        } catch (Throwable e) {
            System.err.println(i);
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        String str = new StringBuilder("计算机").append("软件").toString();

        System.out.println(str.intern() == str); // true

        String str1 = new StringBuilder("ja").append("va").toString();

        System.out.println(str1.intern() == str1); // false

        String str12 = new StringBuilder("计算机").append("软件").toString();

        System.out.println(str12.intern() == str12); // false

    }

}
