class Solution:
    def permute(self, nums: [int]) -> [[int]]:
        def dfs(path):
            if len(nums) == len(path):
                result.append(path)
                return
            for i in nums:
                path.append(i)
                dfs(path)

        result = []
        dfs([])
        return result