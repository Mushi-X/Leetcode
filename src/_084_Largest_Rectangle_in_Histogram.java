import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 84. Largest Rectangle in Histogram
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 *
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
public class _084_Largest_Rectangle_in_Histogram {

    /**
     * 解题思路
     *
     * 首先将原数组按照升序拆分成多个子数组，如果原数组按倒序排列，则反转
     *
     * 遍历每个子数组，这里分为两种情况：
     *
     *     1、第一个元素有可能和前面的柱状图连在一起，形成一个长的矩形。
     *        所以需要向前遍历，找到具体需要在前面哪个位置停下，记录前面宽度
     *     2、数组中所有元素都有可能在后面连续，所以需要向后遍历找到高度结束的位置
     *
     * 所以  矩形面积 = 当前位置高度 * (当前数组宽度+前面数组宽度(在当前数组排第一时才不为0)+后面数组宽度）
     *
     * 比较返回最大面积
     *
     */
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        List<List<Integer>> sortArray = getSortArray(heights);

        if (sortArray.size() >= (length / 2)) {
            int[] reverHeights = new int[length];
            for (int i = 0; i < length; i++) {
                reverHeights[i] = heights[length - i - 1];
            }
            sortArray = getSortArray(reverHeights);
        }

        int maxArea = 0;
        for (int i = 0; i < sortArray.size(); i++) {
            List<Integer> array = sortArray.get(i);
            for (int j = 0, arrayLength = array.size(); j < arrayLength; j++) {
                int area;
                int preWidth = 0, nextWidht = 0;
                int currentArrayNums = i;
                if (j == 0) {
                    while (true) {
                        if (currentArrayNums == 0) {
                            break;
                        }
                        currentArrayNums--;
                        if (sortArray.get(currentArrayNums).get(0) < array.get(j)) {
                            int preArrayWidth = sortArray.get(currentArrayNums).size();
                            for (int k = 0; k < preArrayWidth; k++) {
                                if (sortArray.get(currentArrayNums).get(k) >= array.get(j)) {
                                    preWidth += preArrayWidth - k;
                                    break;
                                }

                            }
                            break;
                        }
                        preWidth += sortArray.get(currentArrayNums).size();
                    }
                }
                currentArrayNums = i;
                while (true) {
                    currentArrayNums++;
                    if (currentArrayNums >= sortArray.size()) {
                        break;
                    }
                    if (sortArray.get(currentArrayNums).get(0) <= array.get(j)) {
                        break;
                    }
                    nextWidht += sortArray.get(currentArrayNums).size();
                }
                area = array.get(j) * (arrayLength + preWidth + nextWidht - j);

                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    private List<List<Integer>> getSortArray(int[] heights) {

        int length = heights.length;
        List<List<Integer>> sortArray = new ArrayList<>();

        boolean sort;
        int sortArrayNums = 0;
        for (int i = 0; i < length; i++) {
            int currentHeight = heights[i];
            sort = (i == 0 || heights[i] >= heights[i - 1]);

            if (!sort) {
                sortArrayNums++;
            }
            if (sortArray.size() <= sortArrayNums) {
                sortArray.add(new ArrayList<>());
            }
            sortArray.get(sortArrayNums).add(currentHeight);
        }
        return sortArray;
    }

    public int _2msSolution(int[] heights) {
        int[] h = new int[2 + heights.length];
        System.arraycopy(heights, 0, h, 1, heights.length);
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(0);
        int area = 0;
        for (int i = 1; i < h.length; ++i) {
            while (h[stk.peek()] > h[i]) {
                area = Math.max(area, h[stk.pop()] * (i - 1 - stk.peek()));
            }
            stk.push(i);
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(new _084_Largest_Rectangle_in_Histogram().largestRectangleArea(new int[]{9,8,7,6,5,4,3,2,1}));
    }

}
