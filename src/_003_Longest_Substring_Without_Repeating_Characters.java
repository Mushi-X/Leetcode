/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class _003_Longest_Substring_Without_Repeating_Characters {

    /**
     * 时间复杂度O(N)
     *
     * 从头开始遍历字符，记录连续的字符，判断是否和前面记录的有重复
     *
     * 如果重复则从重复字符的下标后面截取，并记录最大值。更新当前字符长度。继续遍历
     *
     * 直到剩余字符数量加上当前字符数量小于最大长度 或 遍历结束
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;
        int currentLength = 0;

        StringBuilder substring = new StringBuilder();
        for (int i = 0, charsLength = chars.length; i < charsLength; i++) {
            if (charsLength - i + currentLength < maxLength) {
                return maxLength;
            }
            char aChar = chars[i];
            int index = substring.indexOf(String.valueOf(aChar));
            if (index == -1) {
                substring.append(aChar);
                currentLength++;
                maxLength = maxLength > currentLength ? maxLength : currentLength;

            } else {
                substring = new StringBuilder().append(substring.substring(index + 1));

                substring.append(aChar);
                currentLength = substring.length();
            }
        }
        return maxLength;
    }

}
