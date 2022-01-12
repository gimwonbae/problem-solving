func trap(height []int) int {
    ans := make([]int, len(height))
    top := 0
    
    for i := 0; i < len(height); i++ {
        if top > height[i] {
            ans[i] = top - height[i]
        } else {
            top = height[i]
            ans[i] = 0
        }
    }
    
    top = 0
    
    for i := len(height) - 1; i >= 0; i-- {
        if top > height[i] {
            ans[i] = min(top - height[i], ans[i])
        } else {
            top = height[i]
            ans[i] = 0
        }
    }
    return sum(ans)
}

func sum(a []int) (ans int) {
	ans = 0
	for _, v := range a {
		ans += v
	}
	return
}

func min(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
