1)
import java.util.Arrays;

public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        ArrayPairSum solution = new ArrayPairSum();
        int maxSum = solution.arrayPairSum(nums);
        System.out.println(maxSum);
    }
}

2)
import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfCandies {
    public int distributeCandies(int[] candyType) {
        int maxTypes = candyType.length / 2;
        Set<Integer> uniqueTypes = new HashSet<>();
        for (int candy : candyType) {
            uniqueTypes.add(candy);
            if (uniqueTypes.size() == maxTypes) {
                break;
            }
        }
        return uniqueTypes.size();
    }

    public static void main(String[] args) {
        int[] candyType = {1, 1, 2, 2, 3, 3};
        MaximumNumberOfCandies solution = new MaximumNumberOfCandies();
        int maxDifferentTypes = solution.distributeCandies(candyType);
        System.out.println("Maximum number of different types: " + maxDifferentTypes);
    }
}

3)
import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int longestSubsequence = 0;
        for (int num : countMap.keySet()) {
            if (countMap.containsKey(num + 1)) {
                int currentSubsequence = countMap.get(num) + countMap.get(num + 1);
                longestSubsequence = Math.max(longestSubsequence, currentSubsequence);
            }
        }

        return longestSubsequence;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        LongestHarmoniousSubsequence solution = new LongestHarmoniousSubsequence();
        int longestSubsequenceLength = solution.findLHS(nums);
        System.out.println("Length of the longest harmonious subsequence: " + longestSubsequenceLength);
    }
}


4)
public class FlowerPlanting {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        FlowerPlanting solution = new FlowerPlanting();
        boolean canPlaceFlowers = solution.canPlaceFlowers(flowerbed, n);
        System.out.println(canPlaceFlowers);
    }
}
5)
import java.util.Arrays;

public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        MaximumProduct solution = new MaximumProduct();
        int maxProduct = solution.maximumProduct(nums);
        System.out.println(maxProduct);
    }
}
6)
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        BinarySearch solution = new BinarySearch();
        int index = solution.search(nums, target);
        System.out.println(index);
    }
}
7)
public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                increasing = false;
            }
            if (nums[i] > nums[i - 1]) {
                decreasing = false;
            }
        }

        return increasing || decreasing;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        MonotonicArray solution = new MonotonicArray();
        boolean isMonotonic = solution.isMonotonic(nums);
        System.out.println(isMonotonic);
    }
}
8)
import java.util.Arrays;

public class MinimumScore {
    public int minScore(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int minScore = nums[n - 1] - nums[0];

        for (int i = 1; i <= k; i++) {
            int min = Math.min(nums[0] + i, nums[n - 1] - k + i);
            int max = Math.max(nums[n - 1] - i, nums[0] + k - i);
            minScore = Math.min(minScore, max - min);
        }

        return minScore;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int k = 0;
        MinimumScore solution = new MinimumScore();
        int minScore = solution.minScore(nums, k);
        System.out.println(minScore);
    }
}
