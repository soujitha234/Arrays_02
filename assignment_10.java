1)
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        return isPowerOfThreeHelper(n);
    }

    private boolean isPowerOfThreeHelper(int n) {
        if (n == 1) {
            return true;
        }
        if (n % 3 != 0) {
            return false;
        }
        return isPowerOfThreeHelper(n / 3);
    }
}

2)
public class Solution {
    public int lastRemaining(int n) {
        return lastRemainingHelper(n, true);
    }

    private int lastRemainingHelper(int n, boolean leftToRight) {
        if (n == 1) {
            return 1;
        }
        if (leftToRight) {
            return 2 * lastRemainingHelper(n / 2, false);
        } else {
            if (n % 2 == 1) {
                return 2 * lastRemainingHelper(n / 2, true);
            } else {
                return 2 * lastRemainingHelper(n / 2, true) - 1;
            }
        }
    }
}

3)
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> subsets(String set) {
        List<String> result = new ArrayList<>();
        subsetsHelper(set, "", 0, result);
        return result;
    }

    private void subsetsHelper(String set, String currentSubset, int index, List<String> result) {
        if (index == set.length()) {
            result.add(currentSubset);
            return;
        }
        subsetsHelper(set, currentSubset, index + 1, result); // Exclude current character
        subsetsHelper(set, currentSubset + set.charAt(index), index + 1, result); // Include current character
    }
}

4)
public class Solution {
    public int calculateLength(String str) {
        return calculateLengthHelper(str, 0);
    }

    private int calculateLengthHelper(String str, int index) {
        if (index == str.length()) {
            return 0;
        }
        return 1 + calculateLengthHelper(str, index + 1);
    }
}

5)
public class Solution {
    public int countSubstrings(String str) {
        return countSubstringsHelper(str, 0, str.length() - 1);
    }

    private int countSubstringsHelper(String str, int start, int end) {
        if (start > end) {
            return 0;
        }
        int count = countSubstringsHelper(str, start, end - 1) + countSubstringsHelperWithEnd(str, end, end);
        if (str.charAt(start) == str.charAt(end)) {
            count += 1;
        }
        return count;
    }

    private int countSubstringsHelperWithEnd(String str, int start, int end) {
        if (start == end) {
            return 1;
        }
        if (str.charAt(start) == str.charAt(end)) {
            return countSubstringsHelperWithEnd(str, start + 1, end - 1) + 1;
        }
        return 0;
    }
}

6)
public class Solution {
    public void towerOfHanoi(int N, int source, int destination, int auxiliary) {
        if (N == 1) {
            System.out.println("move disk 1 from rod " + source + " to rod " + destination);
            return;
        }
        towerOfHanoi(N - 1, source, auxiliary, destination);
        System.out.println("move disk " + N + " from rod " + source + " to rod " + destination);
        towerOfHanoi(N - 1, auxiliary, destination, source);
    }
}

7)
public class Solution {
    public void printPermutations(String str) {
        printPermutationsHelper(str, "");
    }

    private void printPermutationsHelper(String str, String prefix) {
        int n = str.length();
        if (n == 0) {
            System.out.print(prefix + " ");
        } else {
            for (int i = 0; i < n; i++) {
                printPermutationsHelper(str.substring(0, i) + str.substring(i + 1), prefix + str.charAt(i));
            }
        }
    }
}

8)
public class Solution {
    public int countConsonants(String str) {
        int count = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z' && !isVowel(ch)) {
                count++;
            }
        }
        return count;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
