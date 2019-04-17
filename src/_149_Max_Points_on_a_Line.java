import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 149. Max Points on a Line
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * <pre>
 * Example 1:
 *
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 *
 * Example 2:
 *
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 *
 * </pre>
 */
public class _149_Max_Points_on_a_Line {

    /**
     * 这题由于精度问题，使用了 BigDecimal 实现，性能较差
     *
     * 后面有时间可以修改 lines 中 key 存 分数，将斜率的分子分母除以两数的最大公约数后优化
     */
    public int maxPoints(int[][] points) {
        int maxPoints = points.length == 0 ? 0 : 1;
        Map<String, Set<String>> lines = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int[] point1 = points[i];
            if (point1.length == 0) {
                continue;
            }
            int x1 = point1[0];
            int y1 = point1[1];

            for (int j = i + 1; j < points.length; j++) {
                int[] point2 = points[j];
                int x2 = point2[0];
                int y2 = point2[1];

                String line = getLine(x1, x2, y1, y2);
                Set<String> pointsOnLine = lines.get(line);
                if (pointsOnLine == null) {
                    pointsOnLine = new HashSet<>();
                }
                pointsOnLine.add(i + "," + x1 + "," + y1);
                pointsOnLine.add(j + "," + x2 + "," + y2);
                lines.put(line, pointsOnLine);

                maxPoints = pointsOnLine.size() > maxPoints ? pointsOnLine.size() : maxPoints;
            }
        }

        return maxPoints;
    }

    private String getLine(int x1, int x2, int y1, int y2) {
        if (x2 - x1 == 0) {
            return "1," + x1;
        } else if (y2 - y1 == 0) {
            return "0," + y2;
        }
        double k, b;
        k = (y2 - y1) / (x2 - x1);
        b = x1 == 0
                ? y2 / (k * x2)
                : y1 / (k * x1);
        return k + "," + b;
    }
}