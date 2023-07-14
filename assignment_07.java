1)
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Set<Character> mappedChars = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                if (mappedChars.contains(c2)) {
                    return false;
                }
                map.put(c1, c2);
                mappedChars.add(c2);
            }
        }

        return true;
    }
}

2)
public class Solution {
    public boolean isStrobogrammatic(String num) {
        int n = num.length();
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            char c1 = num.charAt(left);
            char c2 = num.charAt(right);

            if (c1 == '0' && c2 == '0' || c1 == '1' && c2 == '1' || c1 == '8' && c2 == '8' ||
                    c1 == '6' && c2 == '9' || c1 == '9' && c2 == '6') {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }
}

3)
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            sb.append(digit);
            i--;
            j--;
        }

        return sb.reverse().toString();
    }
}

4)
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(reverseString(word)).append(" ");
        }

        return sb.toString().trim();
    }

    private String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }
}

5)
public class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);

            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }
}

6)
public class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        String doubledS = s + s;
        return doubledS.contains(goal);
    }
}

7)
public class Solution {
    public boolean backspaceCompare(String s, String t) {
        String processedS = processString(s);
        String processedT = processString(t);
        return processedS.equals(processedT);
    }

    private String processString(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

8)
public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];

        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];

            if ((y1 - y0) * (x - x0) != (y - y0) * (x1 - x0)) {
                return false;
            }
        }

        return true;
    }
}
