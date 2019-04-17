import java.util.Stack;

/**
 * 112. Path Sum
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 * <pre>
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * </pre>
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class _112_Path_Sum {

    /**
     * 深度优先算法 遍历树的节点
     * 节点为空时返回 False
     * 节点不为空时，节点的左右节点为空表示该节点为 底部最后一个节点。判断当前节点值是否和 sum 相等
     * 左右节点不为空时，从左侧开始深度遍历继续计算
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}

class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}