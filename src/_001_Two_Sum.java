import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class _001_Two_Sum {

    /**
     * 时间复杂度 O(N)
     * 解题思路
     *
     * 将数组中的数据用一个 Hash Map 缓存
     * Key 为值，Value 为值所在的数组下标
     *
     * 在已知 target 值和 其中一个值的情况下。可以直接通过减法运算得到另一个值
     * 然后查询缓存值是否存在，存在的话返回下标即可求出解
     *
     *
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            cache.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int targetNum = target - nums[i];
            if (cache.containsKey(targetNum) && cache.get(targetNum) != i) {
                return new int[]{i, cache.get(target)};
            }
        }
        return new int[]{};
    }

}

