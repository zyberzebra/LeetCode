package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import problems.P145BinaryTreePostorderTraversal.Companion.postorderTraversal

/**
 * Generated for convenience
 */
class P145BinaryTreePostorderTraversalTest {
    // Helper function to create a tree from a list, specifically for our testing purposes
    private fun createTree(nodes: List<Int?>): TreeNode? {
        if (nodes.isEmpty() || nodes[0] == null) return null

        val root = TreeNode(nodes[0]!!)
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)
        var i = 1

        while (i < nodes.size) {
            val current = queue.removeFirst()
            if (current != null) {
                if (i < nodes.size && nodes[i] != null) {
                    current.left = TreeNode(nodes[i]!!)
                    queue.add(current.left)
                }
                i++
                if (i < nodes.size && nodes[i] != null) {
                    current.right = TreeNode(nodes[i]!!)
                    queue.add(current.right)
                }
                i++
            }
        }
        return root
    }

    @Test
    fun testPostorderTraversalExample1() {
        // Test case 1: Example 1 from the problem statement
        val root = createTree(listOf(1, null, 2, 3))
        val expected = listOf(3, 2, 1)
        assertEquals(expected, postorderTraversal(root))
    }

    @Test
    fun testPostorderTraversalEmptyTree() {
        // Test case 2: Empty tree
        val root = createTree(emptyList())
        val expected = emptyList<Int>()
        assertEquals(expected, postorderTraversal(root))
    }

    @Test
    fun testPostorderTraversalSingleNode() {
        // Test case 3: Single node tree
        val root = createTree(listOf(1))
        val expected = listOf(1)
        assertEquals(expected, postorderTraversal(root))
    }

    @Test
    fun testPostorderTraversalComplexTree() {
        // Test case 4: More complex tree
        val root = createTree(listOf(1, 2, 3, 4, 5, null, 6))
        val expected = listOf(4, 5, 2, 6, 3, 1)
        assertEquals(expected, postorderTraversal(root))
    }

    @Test
    fun testPerformancePostorderTraversal() {
        // Test case 5: Performance test with 100 nodes
        val root = TreeNode(1)
        var current = root
        for (i in 2..100) {
            current.right = TreeNode(i)
            current = current.right!!
        }

        val expected = (100 downTo 1).toList()
        assertEquals(expected, postorderTraversal(root))
    }
}
