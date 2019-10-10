// https://leetcode.com/submissions/detail/189988140/
// Find smallest range cover all k sorted array
// Use a heap to find smallest element in k array, put smallest into queue and
// Count how many array its cover, store latest index for each array
// when count = k, pop each element from queue while it's still maintain
// k array cover, if element pop out = tracked index for that array, decrease count


/*
from heapq import heappush, heappop
from collections import deque

class Solution:
    def smallestRange(self, nums):
        """
        :type nums: List[List[int]]
        :rtype: List[int]
        """
        k = len(nums)
        heap = []
        counter = [None for x in range(k)]
        queue = deque()
        count = 0
        res = float('inf')
        out = []

        for i in range(k):
            heappush(heap, (nums[i][0], i, 0))

        while heap:
            v, i, j = heappop(heap)
            if j+1 < len(nums[i]):
                heappush(heap, (nums[i][j+1], i, j+1))

            queue.append((i, j))
            if counter[i] is None:
                count += 1
            counter[i] = j

            while count == k and queue:
                p, q = queue.popleft()
                if v - nums[p][q] < res:
                    res = v - nums[p][q]
                    out = [nums[p][q], v]

                if counter[p] == q:
                    counter[p] = None
                    count -= 1
        return out
*/
