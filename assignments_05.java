1)
public class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result = new int[m][n];

        if (original.length != m * n) {
            return new int[0][0];
        }

        int index = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[index++];
            }
        }

        return result;
    }
}
2)
public class Solution {
    public int arrangeCoins(int n) {
        int rows = 0;
        int coins = n;
        int i = 1;

        while (coins >= i) {
            coins -= i;
            i++;
            rows++;
        }

        return rows;
    }
}

3)
import java.util.Arrays;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] squaredNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            squaredNums[i] = nums[i] * nums[i];
        }
        Arrays.sort(squaredNums);
        return squaredNums;
    }
}
4)
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> missingNums1 = new ArrayList<>();
        List<Integer> missingNums2 = new ArrayList<>();

        for (int num : nums1) {
            if (!set2.contains(num)) {
                missingNums1.add(num);
            }
        }

        for (int num : nums2) {
            if (!set1.contains(num)) {
                missingNums2.add(num);
            }
        }

        answer.add(missingNums1);
        answer.add(missingNums2);

        return answer;
    }
}
5)
public int distanceValue(int[] arr1, int[] arr2, int d) {
    int distance = 0;
    for (int num1 : arr1) {
        boolean valid = true;
        for (int num2 : arr2) {
            if (Math.abs(num1 - num2) <= d) {
                valid = false;
                break;
            }
        }
        if (valid) {
            distance++;
        }
    }
    return distance;
}

6)
public List<Integer> findDuplicates(int[] nums) {
    List<Integer> duplicates = new ArrayList<>();
    for (int num : nums) {
        int index = Math.abs(num) - 1;
        if (nums[index] < 0) {
            duplicates.add(Math.abs(num));
        } else {
            nums[index] = -nums[index];
        }
    }
    return duplicates;
}

7)
public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] > nums[right]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return nums[left];
}

8)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[]{};
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : changed) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> originalList = new ArrayList<>();
        for (int num : changed) {
            if (countMap.getOrDefault(num, 0) == 0) {
                continue;
            }

            if (countMap.getOrDefault(num * 2, 0) == 0) {
                return new int[]{};
            }

            originalList.add(num);
            countMap.put(num, countMap.getOrDefault(num, 0) - 1);
            countMap.put(num * 2, countMap.getOrDefault(num * 2, 0) - 1);
        }

        int[] originalArray = new int[originalList.size()];
        for (int i = 0; i < originalList.size(); i++) {
            originalArray[i] = originalList.get(i);
        }

        return originalArray;
    }
}
