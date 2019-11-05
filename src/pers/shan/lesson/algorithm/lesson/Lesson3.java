package pers.shan.lesson.algorithm.lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组、链表、跳表
 *
 * @author: shanxiao
 * @date: 2019/11/05
 */
public class Lesson3 {

    /**
     * https://leetcode-cn.com/problems/move-zeroes/
     */
    public void moveZeroes(int[] nums) {
        // 记录非0元素的位置
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    /**
     * https://leetcode-cn.com/problems/container-with-most-water/
     */
    public int maxArea(int[] height) {
        int max = 0;
        // 左右边界向中间收敛
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            // 谁小谁往中间移动
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight;
            max = Math.max(max, area);
        }
        return max;
    }


    /**
     * https://leetcode-cn.com/problems/climbing-stairs/
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    /**
     * https://leetcode-cn.com/problems/3sum/
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int k = 0; nums[k] <= 0 && k < nums.length - 2; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) {
                        ;
                    }
                } else if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) {
                        ;
                    }
                } else {
                    result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[++i]) {
                        ;
                    }
                    while (i < j && nums[j] == nums[--j]) {
                        ;
                    }
                }
            }
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/linked-list-cycle/
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Lesson3().threeSum(new int[]{1, -1, -1, 0});
        System.out.println(list);
    }


}
