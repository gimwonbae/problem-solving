func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	var ans *TreeNode
	var nodeHasPQ func(root, p, q *TreeNode) bool

	nodeHasPQ = func(root, p, q *TreeNode) bool {
		if root == nil {
			return false
		}

		var left, cur, right int
		if nodeHasPQ(root.Left, p, q) {
			left = 1
		}
		if nodeHasPQ(root.Right, p, q) {
			right = 1
		}
		if root == p || root == q {
			cur = 1
		}
		if left+cur+right >= 2 {
			ans = root
		}

		return left+cur+right > 0
	}

	nodeHasPQ(root, p, q)
	return ans
}
