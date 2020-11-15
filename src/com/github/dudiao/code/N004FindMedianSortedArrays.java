package com.github.dudiao.code;

/**
 * 寻找两个正序数组的中位数
 * <p>
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * </p>
 *
 * @author songyinyin
 * @date 2020/11/15 下午 05:33
 */
public class N004FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2}, nums2 = new int[]{3, 4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println("数组的中位数: " + medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int resultLength = nums1.length + nums2.length;
        int[] result = new int[resultLength];
        int index = 0;
        int i = 0;
        vo:
        for (int j = 0; j < nums1.length; j++) {
            for (; i < nums2.length; ) {
                if (nums1[j] <= nums2[i]) {
                    result[index++] = nums1[j];
                    continue vo;
                } else {
                    result[index++] = nums2[i];
                    i++;
                }
            }
            result[index++] = nums1[j];
        }
        for (; i < nums2.length; i++) {
            result[index++] = nums2[i];
        }

        if (resultLength % 2 == 0) {
            return (result[resultLength / 2 - 1] + result[resultLength / 2]) / 2.0;
        }

        return result[resultLength / 2];
    }

    /**
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
     *
     * 二分法，时间复杂度是 O(log（min（m，n）），空间复杂度是 O ( 1 )O(1)
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            // 保证 m <= n
            return findMedianSortedArrays2(nums2, nums1);
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && nums2[j - 1] > nums1[i]) {
                // i 需要增大
                iMin = i + 1;
            } else if (i != 0 && j != n && nums1[i - 1] > nums2[j]) {
                // i 需要减小
                iMax = i - 1;
            } else {
                // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }
                //如果是偶数的话返回结果
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
