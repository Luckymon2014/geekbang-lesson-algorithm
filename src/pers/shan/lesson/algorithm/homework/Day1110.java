package pers.shan.lesson.algorithm.homework;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water
 *
 * @author: shanxiao
 * @date: 2019/11/10
 */
public class Day1110 {
    public int trap(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        // 左右指针往里找高度较低的
        while (left < right) {
            // 如果左边高度低，右边肯定能接住水，左边往里找，递减则可以接水，递增则记录当前左边的最高可接住的高度
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left++];
                }
            } else { // 右侧高度低同理
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right--];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Day1110().trap(height));
    }
}
