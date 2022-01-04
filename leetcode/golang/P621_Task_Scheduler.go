import (
	"sort"
)

func leastInterval(tasks []byte, n int) int {
	alphabets := make([]int, 26)
	for _, v := range tasks {
		alphabets[int(v)-'A']++
	}

	sort.Ints(alphabets)
	idle := (alphabets[25] - 1) * n

	for i := 24; i >= 0; i-- {
		idle -= min(alphabets[i], alphabets[25]-1)
	}

	return len(tasks) + max(idle, 0)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
