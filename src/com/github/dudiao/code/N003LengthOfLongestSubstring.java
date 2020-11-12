package com.github.dudiao.code;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * </p>
 *
 * @author songyinyin
 * @date 2020/9/17 下午 10:40
 */
public class N003LengthOfLongestSubstring {

    public static void main(String[] args) {
        String str = "N003LengthOfLongestSubstring";
        int num = lengthOfLongestSubstring(str);
        System.out.println("length=" + num);

        String maxSubStr = strOfLongestSubstring(str);
        System.out.println("maxSubStr=" + maxSubStr);
    }

    /**
     * 字符的最长子串长度
     */
    public static int lengthOfLongestSubstring(String str) {
        long length = str.length();
        // 哈希集合，记录每个字符是否出现过 s = abcabcbb
        Set<Character> container = new HashSet<>();
        // 右指针，初始值为 0，相当于我们在字符串的左边界的左侧，还没有开始移动
        int right = 0, answer = 0;
        for (int left = 0; left < length; left++) {
            if (left != 0) {
                // 左指针向右移动一格，移除一个字符
                container.remove(str.charAt(left - 1));
            }
            // 不断地移动右指针
            while (right < length && !container.contains(str.charAt(right))) {
                container.add(str.charAt(right));
                right++;
            }
            // 第 left 到 right 个字符是一个极长的无重复字符子串 left=0 (abc)abcbb right=2
            answer = Math.max(answer, right - left);
        }
        return answer;
    }

    /**
     * 字符的最长子串
     */
    public static String strOfLongestSubstring(String str) {
        long length = str.length();
        // 哈希集合，记录每个字符是否出现过 s = abcabcbb
        Set<Character> container = new HashSet<>();
        // 右指针，初始值为 0，相当于我们在字符串的左边界的左侧，还没有开始移动
        int right = 0, max = 0;
        // 最长子串的起始坐标
        int beginIndex = 0, endIndex = 0;
        for (int left = 0; left < length; left++) {
            if (left != 0) {
                // 左指针向右移动一格，移除一个字符
                container.remove(str.charAt(left - 1));
            }
            // 不断地移动右指针
            while (right < length && !container.contains(str.charAt(right))) {
                container.add(str.charAt(right));
                right++;
            }
            // 第 left 到 right 个字符是一个极长的无重复字符子串 left=0 (abc)abcbb right=2
            if (right - left > max) {
                max = right - left;
                beginIndex = left;
                endIndex = right;
            }
        }
        return str.substring(beginIndex, endIndex);
    }
}
