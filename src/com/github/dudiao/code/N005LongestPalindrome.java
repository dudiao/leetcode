package com.github.dudiao.code;

/**
 * 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author songyinyin
 * @date 2020/12/7 下午 10:59
 */
public class N005LongestPalindrome {

    public static void main(String[] args) {
        String str = "cabdkac";
        System.out.println("字符串：" + str + "，最长回文子串为：" + longestPalindrome(str));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            if (isPalindrome(s)) {
                return s;
            }
            return s.substring(0, 1);
        }
        if (isPalindrome(s)) {
            return s;
        }

        // 临时存放最长子串
        String tmp = "";
        // s = "abcdcba" s.length() = 7
        vo:
        for (int left = 0; left < s.length(); left++) {
            for (int right = s.length(); right > 1; right--) {
                if (left == right) {
                    continue vo;
                }
                String subStr = s.substring(left, right);
                if (isPalindrome(subStr)) {
                    tmp = subStr.length() > tmp.length() ? subStr : tmp;
                }
            }
        }

        return tmp;
    }

    /**
     * 判断是否是回文字符串
     *
     * @param str
     * @return
     */
    private static boolean isPalindrome(String str) {
        // "cabdkac" str.length()=7
        int start = 0;
        int end = str.length() - 1;
        int foreachNum = str.length() / 2;
        for (int i = 0; i < foreachNum; i++) {
            int left = start + i;
            int right = end - i;
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
