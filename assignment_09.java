1)
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        
        return (n & (n - 1)) == 0;
    }
}
2)
public class Solution {
    public int sumOfFirstNNumbers(int n) {
        return (n * (n + 1)) / 2;
    }
}

3)
public class Solution {
    public int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}

4)
public class Solution {
    public int power(int N, int P) {
        if (P == 0) {
            return 1;
        }

        int result = 1;

        for (int i = 0; i < P; i++) {
            result *= N;
        }

        return result;
    }
}

5)
public class Solution {
    public int findMaxElement(int[] arr) {
        return findMax(arr, 0, arr.length - 1);
    }

    private int findMax(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }

        int mid = (start + end) / 2;
        int leftMax = findMax(arr, start, mid);
        int rightMax = findMax(arr, mid + 1, end);

        return Math.max(leftMax, rightMax);
    }
}

6)
public class Solution {
    public int findNthTerm(int a, int d, int N) {
        return a + (N - 1) * d;
    }
}

7)
public class Solution {
    public void printPermutations(String s) {
        printPermutationsHelper(s, 0, s.length() - 1);
    }

    private void printPermutationsHelper(String s, int l, int r) {
        if (l == r) {
            System.out.println(s);
        } else {
            for (int i = l; i <= r; i++) {
                s = swap(s, l, i);
                printPermutationsHelper(s, l + 1, r);
                s = swap(s, l, i); // backtrack
            }
        }
    }

    private String swap(String s, int i, int j) {
        char[] charArray = s.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}

8)
public class Solution {
    public int findProduct(int[] arr) {
        int product = 1;

        for (int num : arr) {
            product *= num;
        }

        return product;
    }
}
