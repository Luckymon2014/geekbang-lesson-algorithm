package pers.shan.lesson.algorithm.homework;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * @author: shanxiao
 * @date: 2019/11/06
 */
public class Day1106 {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        // 反转整个数组
        reverse(nums, 0, nums.length - 1);
        // 反转k之前的数组
        reverse(nums, 0, k - 1);
        // 反转k之后的数组
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        new Day1106().rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }

}
