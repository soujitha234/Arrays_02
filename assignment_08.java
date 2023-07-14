1)
public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1),
                                        dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }

        return dp[m][n];
    }
}

2)
import java.util.Stack;

public class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                starStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            if (leftStack.pop() > starStack.pop()) {
                return false;
            }
        }

        return leftStack.isEmpty();
    }
}

3)
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }

        return dp[m][n];
    }
}

4)
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    private int index;

    public TreeNode str2tree(String s) {
        if (s.isEmpty()) {
            return null;
        }

        index = 0;
        return buildTree(s);
    }

    private TreeNode buildTree(String s) {
        StringBuilder sb = new StringBuilder();

        while (index < s.length() && Character.isDigit(s.charAt(index)) || s.charAt(index) == '-') {
            sb.append(s.charAt(index));
            index++;
        }

        int val = Integer.parseInt(sb.toString());
        TreeNode node = new TreeNode(val);

        if (index < s.length() && s.charAt(index) == '(') {
            index++; // Skip '('
            node.left = buildTree(s);
            index++; // Skip ')'
        }

        if (index < s.length() && s.charAt(index) == '(') {
            index++; // Skip '('
            node.right = buildTree(s);
            index++; // Skip ')'
        }

        return node;
    }
}

5)
public class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int count = 1;
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (i < n && chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[index++] = chars[i - 1];

                if (count > 1) {
                    String countStr = Integer.toString(count);

                    for (char c : countStr.toCharArray()) {
                        chars[index++] = c;
                    }
                }

                count = 1;
            }
        }

        return index;
    }
}

6)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int matchCount = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            if (pMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

                if (windowMap.get(c).equals(pMap.get(c))) {
                    matchCount++;
                }
            }

            right++;

            while (matchCount == pMap.size()) {
                if (right - left == p.length()) {
                    result.add(left);
                }

                char leftChar = s.charAt(left);

                if (pMap.containsKey(leftChar)) {
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                    if (windowMap.get(leftChar) < pMap.get(leftChar)) {
                        matchCount--;
                    }
                }

                left++;
            }
        }

        return result;
    }
}

7)
import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(count);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                StringBuilder previousString = stringStack.pop();
                int repeatCount = countStack.pop();

                for (int i = 0; i < repeatCount; i++) {
                    previousString.append(currentString);
                }

                currentString = previousString;
            } else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
}

8)
public class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;

                if (count[c - 'a'] > 1) {
                    return true;
                }
            }

            return false;
        }

        int first = -1;
        int second = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }

        return (second != -1 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first));
    }
}
