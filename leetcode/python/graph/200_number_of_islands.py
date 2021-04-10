class Solution:
    def numIslands(self, grid: [[str]]) -> int:
        def dfs(i, j):
            if i<0 or i>len(grid)-1 or\
                j<0 or j>len(grid[i])-1 or\
                grid[i][j] == 0:
                return
            grid[i][j] = 0
            dfs(i, j+1)
            dfs(i, j-1)
            dfs(i-1,j)
            dfs(i+1,j)

        if not grid:
            return 0
        cnt = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == '1':
                    dfs(i, j)
                    cnt += 1
        return cnt
