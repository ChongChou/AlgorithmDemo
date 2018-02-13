package com.chou.example.algorithmdemo.test;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by zhouchong on 2018/2/12.
 * 练习题
 */

public class MyTest {
    public static int test_1_1_1_a() {
        // 7
        return (0 + 15) / 2;
    }

    public static double test_1_1_1_b() {
        // 0.000002 * 100000000.1 = 200.0000002
        BigDecimal bigDecimal = new BigDecimal(2.0);
        BigDecimal newBig = new BigDecimal(10);
        BigDecimal powBig = newBig.pow(6);
        BigDecimal secBig = new BigDecimal(1);
        return bigDecimal.multiply(secBig.divide(powBig)).multiply(new BigDecimal(100000000.1)).doubleValue();
    }

    public static boolean test_1_1_1_c() {
        // true
        return true && false || true && true;
    }

    public static double test_1_1_2_a() {
        // 3.236 / 2 = 1.0
        return (1 + 2.236) / 2;
    }

    public static double test_1_1_2_b() {
        // 10.0
        return 1 + 2 + 3 + 4.0;
    }

    public static boolean test_1_1_2_c() {
        // true
        return 4.1 >= 4;
    }

    public static String test_1_1_2_d() {
        // 33
        return 1 + 2 + "3";
    }

    public static void test_1_1_6() {
        // 斐波那契
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }

    public static void test_1_1_7_a() {
        double t = 9.0;
        while (Math.abs(t-9.0/t) > .001) {
            t = (9.0 / t + t) / 2.0;
        }
        System.out.printf("%.5f", t);
    }

    public static long test_1_1_7_b() {
        // 1+2+3+...+999 = 1000 * 999 / 2 = 500 * 999 = 500 * (1000 - 1) = 500,000 - 500 = 499,500
        long sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        return sum;
    }

    public static int test_1_1_7_c() {
        // i(n) = 2^n; n = 10时，i(10) = 2^10 = 1024 > 1000, 外层循环走了10次(2^0 ~ 2^9)，内层每次+1000，返回10000
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * System.out.println   传入char，打印char类型，
     *                      传入char+char，打印int(char的+运算为ascII码整数运算)
     *                      a = 97  A = 65
     *
     */
    public static void test_1_1_8() {
        // b
        System.out.println('b');
        // 98 + 99 = 197
        int a = 'a';    // 97
        int b = 'b';    // 98
        int c = 'c';    // 99
        int A = 'A';    // 65
        System.out.println('b' + 'c');
        // e
        System.out.println((char) ('a' + 4));
    }

    /**
     * 辗转相除法，除2取余得最高位，整数部分再除2取余依次往上
     * @param n 需要转换成二进制的int数
     * @return  二进制字符串
     */
    public static String test_1_1_9(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i /= 2) {
            sb.insert(0, String.valueOf(i % 2));
        }
        return sb.toString();
    }

    public static void test_1_1_11(boolean[][] a) {
        int maxLength = 0;
        for (int i = 0; i < a.length; i++) {
            maxLength = a[i].length > maxLength ? a[i].length : maxLength;
            System.out.print(i + "\t");
            for (int j = 0; j < a[i].length; j++) {
                System.out.print((a[i][j] ? "+" : "-") + "\t");
            }
            System.out.println("\n");
        }
        for (int i = 0; i < maxLength; i++) {
            System.out.print("\t" + i);
        }
    }

    public static void test_1_1_12() {
        //
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        // {9, 8, 7, 6, ... , 2, 1, 0}
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        // {0, 1, 2, ... , 6, 7, 8, 9}
        for (int i = 0; i < 10; i++)
            System.out.println(i);
    }

    /**
     * 打印一个M行N列二维数组的转置(行列交换)
     * @param a 二维数组
     * @param M 行数
     * @param N 列数
     */
    public static void test_1_1_13(String[][] a, int M, int N) {
        System.out.print("N\\M\t");
        for (int i = 0; i < M; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.print(i+"\t");
            for (int j = 0; j < M; j++) {
                System.out.print(a[j][i] + "\t");
            }
            System.out.println();
        }
    }

    public static int test_1_1_14(int N) {
        int k = 0;
        for (int i = 1; i <= N; i *= 2) {
            k++;
        }
        return k - 1;
    }

    public static int[] test_1_1_15(int[] a, int M) {
        int[] b = new int[M];
        HashMap<Integer, Integer> map = getCountMap(a);
        for (int i = 0; i < M; i++) {
            Integer count = map.get(i);
            b[i] = count == null ? 0 : count;
        }
        return b;
    }

    private static HashMap<Integer, Integer> getCountMap(int[] param) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : param) {
            Integer count = map.get(i);
            if (count == null) {
                map.put(i, 1);
            } else {
                map.put(i, count+1);
            }
        }
        return map;
    }

    public static int sumArray(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }

    public static String test_1_1_16(int n) {
        if (n <= 0) return "";
        return test_1_1_16(n - 3) + n + test_1_1_16(n - 2) + n;
    }
}
