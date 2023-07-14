1)
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] result = new int[n + 1];
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            nums.add(i);
        }

        int left = 0;
        int right = n;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                result[i] = nums.get(left++);
            } else {
                result[i] = nums.get(right--);
            }
        }

        result[n] = nums.get(left);

        return result;
    }
}

2)
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}

3)
public class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }

        int i = 0;

        // Increasing phase
        while (i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        // Peak should not be the first or last element
        if (i == 0 || i == n - 1) {
            return false;
        }

        // Decreasing phase
        while (i < n - 1 && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == n - 1;
    }
}

4)
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, -1);
        int maxLength = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;

            if (countMap.containsKey(count)) {
                maxLength = Math.max(maxLength, i - countMap.get(count));
            } else {
                countMap.put(count, i);
            }
        }

        return maxLength;
    }
}

5)
import java.util.Arrays;

public class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int minProductSum = 0;

        for (int i = 0; i < n; i++) {
            minProductSum += nums1[i] * nums2[n - i - 1];
        }

        return minProductSum;
    }
}

6)
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

7)
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int num = 1;
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Traverse right
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = num++;
            }
            rowStart++;

            // Traverse down
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = num++;
            }
            colEnd--;

            // Traverse left
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    matrix[rowEnd][i] = num++;
                }
                rowEnd--;
            }

            // Traverse up
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    matrix[i][colStart] = num++;
                }
                colStart++;
            }
        }

        return matrix;
    }
}

8)
public class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat1[0].length;
        int n = mat2[0].length;

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < k; l++) {
                    result[i][j] += mat1[i][l] * mat2[l][j];
                }
            }
        }

        return result;
    }
}
