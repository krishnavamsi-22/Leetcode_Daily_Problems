from collections import Counter

class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        # Count occurrences of each element in the list
        counts = Counter(nums)
        
        # Filter out elements that occur only once
        result = [num for num, count in counts.items() if count == 1]
        
        return result
