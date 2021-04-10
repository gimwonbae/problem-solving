class Solution:
    def letterCombinations(self, digits: str) -> [str]:
        def dfs(index, path):
            if len(digits) == len(path):
                result.append(path)
                return

            for i in range(index, len(digits)):
                for j in arr[digits[i]]:
                    dfs(i + 1, path + j)

        if not digits:
            return []
        arr = {'2': 'abc', '3':'def', '4':'ghi', '5':'jkl',
               '6': 'mno', '7':'pqrs', '8':'tuv', '9':'wxyz'}
        result = []
        dfs(0, '')

        return result
    