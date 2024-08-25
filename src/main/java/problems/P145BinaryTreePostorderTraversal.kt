package problems

class TreeNode(
    var `val`: Int,
) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * Postorder traversal of a binary tree.
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-postorder-traversal">binary-tree-postorder-traversal</a>
 */
class P145BinaryTreePostorderTraversal {
    companion object {
        fun postorderTraversal(root: TreeNode?): List<Int> {
            if (root == null) {
                return emptyList()
            }
            return postorderTraversal(root.left) + postorderTraversal(root.right) + root.`val`
        }
    }
}
