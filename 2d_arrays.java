1)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfThreeArrays {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> intersection = new ArrayList<>();

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            int num1 = arr1[i], num2 = arr2[j], num3 = arr3[k];

            if (num1 == num2 && num2 == num3) {
                intersection.add(num1);
                i++;
                j++;
                k++;
            } else if (num1 <= num2 && num1 <= num3) {
                i++;
            } else if (num2 <= num1 && num2 <= num3) {
                j++;
            } else {
                k++;
            }
        }

        return intersection;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 5, 7, 9};
        int[] arr3 = {1, 3, 4, 5, 8};
        IntersectionOfThreeArrays solution = new IntersectionOfThreeArrays();
        List<Integer> result = solution.arraysIntersection(arr1, arr2, arr3);
        System.out.println(result);
    }
}

2)
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArraysDifference {
    public List<List<Integer>> findArrayDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> diff1 = new ArrayList<>();
        List<Integer> diff2 = new ArrayList<>();

        for (int num : nums1) {
            if (!set2.contains(num)) {
                diff1.add(num);
            }
        }

        for (int num : nums2) {
            if (!set1.contains(num)) {
                diff2.add(num);
            }
        }

        answer.add(diff1);
        answer.add(diff2);

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        ArraysDifference solution = new ArraysDifference();
        List<List<Integer>> result = solution.findArrayDifference(nums1, nums2);
        System.out.println(result);
    }
}

3)
public class MatrixTranspose {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] transposeMatrix = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }

        return transposeMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MatrixTranspose solution = new MatrixTranspose();
        int[][] transpose = solution.transpose(matrix);

        // Print the transpose matrix
        for (int[] row : transpose) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

4)
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
5)
public class ArrangeCoins {
    public int arrangeCoins(int n) {
        int completeRows = 0;
        int currentRow = 1;

        while (n >= currentRow) {
            n -= currentRow;
            currentRow++;
            completeRows++;
        }

        return completeRows;
    }

    public static void main(String[] args) {
        int n = 5;
        ArrangeCoins solution = new ArrangeCoins();
        int completeRows = solution.arrangeCoins(n);
        System.out.println(completeRows);
    }
}

6)
import java.util.Arrays;

public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            squares[i] = nums[i] * nums[i];
        }

        Arrays.sort(squares);

        return squares;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        SortedSquares solution = new SortedSquares();
        int[] sortedSquares = solution.sortedSquares(nums);
        System.out.println(Arrays.toString(sortedSquares));
    }
}

7)
public class MaxCount {
    public int maxCount(int m, int n, int[][] ops) {
        int minX = m;
        int minY = n;

        for (int[] op : ops) {
            minX = Math.min(minX, op[0]);
            minY = Math.min(minY, op[1]);
        }

        return minX * minY;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] ops = {{2, 2}, {3, 3}};
        MaxCount solution = new MaxCount();
        int maxCount = solution.maxCount(m, n, ops);
        System.out.println(maxCount);
    }
}

8)
import java.util.Arrays;

public class ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            result[index++] = nums[i];
            result[index++] = nums[n + i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        ShuffleArray solution = new ShuffleArray();
        int[] shuffledArray = solution.shuffle(nums, n);
        System.out.println(Arrays.toString(shuffledArray));
    }
}
