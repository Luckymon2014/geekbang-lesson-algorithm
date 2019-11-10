package pers.shan.lesson.algorithm.homework;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author: shanxiao
 * @date: 2019/11/10
 */
public class Day1108 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] _nums1 = new int[m];
        System.arraycopy(nums1, 0, _nums1, 0, m);
        // p-nums1的指针，q-nums2的指针，比较两个大小，小的放到结果里去然后后移
        int p = 0, q = 0;
        // 当前结果中待写入的指针位置
        int i = 0;
        while (p < m && q < n) {
            nums1[i++] = _nums1[p] <= nums2[q] ? _nums1[p++] : nums2[q++];
        }
        // 把剩下的放入结果中
        if (p < m) {
            System.arraycopy(_nums1, p, nums1, p + q, m + n - p - q);
        }
        if (q < n) {
            System.arraycopy(nums2, q, nums1, p + q, m + n - p - q);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        new Day1108().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
