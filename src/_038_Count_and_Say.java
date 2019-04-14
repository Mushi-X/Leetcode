/**
 * 38. Count and Say
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 */
public class _038_Count_and_Say {

    /**
     * 时间复杂度 O(N)
     *
     * 这题要用递归的思路去解决
     * 从题意可以知道，序列下一个数的值为 上一个序列的值进行 count and say
     * 如 2 的值 11 就是读 1 的值 1个1
     * 将 count 结果和 say 的值拼接就是下一个序列的值
     *
     * 那么我们在实现的过成功，就需要判断当前是不是序列开始
     * 是的时候返回1，
     * 不是就先获取上一个 序列的值
     *
     * 即下面这段代码
     *
     * if (n == 1) {
     *      return "1";
     * }
     * String lastResult = countAndSay(n - 1);
     *
     * 知道序列值之后进行 count say 即可
     *
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String lastResult = countAndSay(n - 1);
        char[] strArray = lastResult.toCharArray();
        int count = 0;
        int say = 0;
        StringBuilder result = new StringBuilder();
        for (char c : strArray) {
            if (say > 0 && say != (c - 48)) {
                result.append(count).append(say);
                count = 0;
                say = 0;
            }
            count++;
            say = c - 48;

        }
        if (count > 0 && say > 0) {
            result.append(count).append(say);
        }
        return result.toString();
    }

}
