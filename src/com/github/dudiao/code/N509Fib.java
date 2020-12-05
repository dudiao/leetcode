package com.github.dudiao.code;

/**
 * 斐波那契数
 *
 * @author songyinyin
 * @date 2020/12/2 下午 09:43
 */
public class N509Fib {

    public static void main(String[] args) {
        int n = 1;
        System.out.println("斐波那契数，f(" + n + ") = " + fib(n));
    }

    public static int fib(int n) {
        int size = Math.max(n, 1) + 1;
        int[] arr = new int[size];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 0; i <= n - 2; i++) {
            arr[i + 2] = arr[i] + arr[i + 1];
        }
        return arr[n];
    }
}
