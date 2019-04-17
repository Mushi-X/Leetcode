/**
 * 41. First Missing Positive
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 */
public class _041_First_Missing_Positive {

    /**
     * 定义一个和原数组长度一样的数组，将原数组中的正数在新数组中标记下标值为1
     * 遍历新数组，找到第一个值不为0的下标。返回下标值加一
     * 否则返回数组长度加一
     */
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int[] cache = new int[length];
        for (int num : nums) {
            if (num > 0 && num <= length) {
                cache[num - 1] = 1;
            }
        }
        for (int i = 0; i < length; i++) {
            if (cache[i] == 0) {
                return i + 1;
            }
        }
        return length + 1;
    }

}
