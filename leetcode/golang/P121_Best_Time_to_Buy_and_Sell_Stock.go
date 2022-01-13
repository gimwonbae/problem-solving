func maxProfit(prices []int) int {
	ans, minPrice := 0, 10001

	for i := 0; i < len(prices); i++ {
		price := prices[i]
		if minPrice > price {
			minPrice = price
		} else {
			ans = max(ans, price-minPrice)
		}
	}
	return ans
}

func max(a, b int) int {
	if a < b {
		return b
	} else {
		return a
	}
}
