from collections import Counter


class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        counter = Counter(stones)
        cnt = 0
        for item in jewels:
            cnt += counter[item]
        return cnt
