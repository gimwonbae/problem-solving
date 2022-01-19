type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func rob(root *TreeNode) int {
	unUsed, used := maxRob(root)
	return max(unUsed, used)
}

func maxRob(root *TreeNode) (int, int) {
	if root == nil {
		return 0, 0
	}
	leftUnUsed, leftUsed := maxRob(root.Left)
	rightUnUsed, rightUsed := maxRob(root.Right)

	unUsed := max(leftUnUsed, leftUsed) + max(rightUnUsed, rightUsed)
	used := root.Val + leftUnUsed + rightUnUsed
	return unUsed, used
}

func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
