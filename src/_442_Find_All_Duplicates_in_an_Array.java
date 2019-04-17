import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 */
public class _442_Find_All_Duplicates_in_an_Array {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0, length = nums.length; i < length; i++) {
            int realVal = nums[i];
            if (realVal > length) {
                realVal = realVal - length;
            }
            if (nums[realVal - 1] > length) {
                result.add(realVal);
            } else {
                nums[realVal - 1] = realVal + length;
            }
        }
        return result;
    }

}
