package pers.shan.lesson.algorithm.homework;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/
 *
 * @author: shanxiao
 * @date: 2019/11/05
 */
public class Day1105 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int p = 0;
        for (int q = 1; q < nums.length; q++) {
            if (nums[p] != nums[q]) {
                p++;
                nums[p] = nums[q];
            }
        }
        return p + 1;
    }

}
