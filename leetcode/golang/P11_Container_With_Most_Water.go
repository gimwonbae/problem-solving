func maxArea(height []int) int {
    ans := 0
    left := 0
    right := len(height) - 1

    for left < right {
	if height[left] < height[right] {
	    ans = max(ans, (right - left) * height[left])
	    left++
	} else {
	    ans = max(ans, (right - left) * height[right])
	    right--
	}
    }
    return ans
}

func max(a int, b int) int {
    if a < b {
	return b
    } else {
        return a
    }
}
