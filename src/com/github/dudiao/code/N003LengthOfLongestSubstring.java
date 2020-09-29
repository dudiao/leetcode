package com.github.dudiao.code;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 *     https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * </p>
 *
 * @author songyinyin
 * @date 2020/9/17 下午 10:40
 */
public class N003LengthOfLongestSubstring {

    public static void main(String[] args) {
        int num = lengthOfLongestSubstring("abcabcbb");
        System.out.println("length=" + num);
    }

    public static int lengthOfLongestSubstring(String s) {
        // s = abcabcbb
        Set<Character> container = new HashSet<>();
        int left = -1, right =0;
        return -1;
    }
}
