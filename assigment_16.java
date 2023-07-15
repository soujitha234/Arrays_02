1)
import java.util.*;

public class NextGreaterFrequency {
    public static int[] nextGreaterFrequency(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int[] result = new int[arr.length];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            while (!stack.isEmpty() && frequencyMap.get(stack.peek()) <= frequencyMap.get(num)) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }

            stack.push(num);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 2, 1};
        int[] result = nextGreaterFrequency(arr);
        System.out.println(Arrays.toString(result)); // Output: [-1, -1, 1, 2, 2, 1, -1]
    }
}

2)
import java.util.*;

public class SortStack {
    public static void sortStack(Stack<Integer> stack) {
        if (stack == null || stack.isEmpty()) {
            return;
        }

        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            int current = stack.pop();

            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                stack.push(tempStack.pop());
            }

            tempStack.push(current);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        sortStack(stack);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " "); // Output: 3 23 31 34 92 98
        }
    }
}

3)
import java.util.Stack;

public class DeleteMiddleStack {
    public static void deleteMiddle(Stack<Integer> stack, int middle) {
        if (stack.isEmpty() || middle < 0 || middle >= stack.size()) {
            return;
        }

        Stack<Integer> tempStack = new Stack<>();
        int count = 0;

        while (!stack.isEmpty()) {
            if (count == middle) {
                stack.pop();
                break;
            }

            tempStack.push(stack.pop());
            count++;
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int middle = stack.size() / 2;
        deleteMiddle(stack, middle);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " "); // Output: 1 2 4 5
        }
    }
}

4)
import java.util.*;

public class CheckQueueOrder {
    public static boolean checkQueueOrder(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        int expected = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == expected) {
                expected++;
            } else {
                if (!stack.isEmpty() && stack.peek() == expected) {
                    stack.pop();
                    expected++;
                    queue.offer(current);
                } else {
                    stack.push(current);
                }
            }
        }

        while (!stack.isEmpty() && stack.peek() == expected) {
            stack.pop();
            expected++;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.offer(5);
        queue1.offer(1);
        queue1.offer(2);
        queue1.offer(3);
        queue1.offer(4);
        System.out.println(checkQueueOrder(queue1)); // Output: true

        Queue<Integer> queue2 = new LinkedList<>();
        queue2.offer(5);
        queue2.offer(1);
        queue2.offer(2);
        queue2.offer(6);
        queue2.offer(3);
        queue2.offer(4);
        System.out.println(checkQueueOrder(queue2)); // Output: false
    }
}

5)
import java.util.Stack;

public class ReverseNumber {
    public static int reverseNumber(int num) {
        Stack<Integer> stack = new Stack<>();

        while (num != 0) {
            int digit = num % 10;
            stack.push(digit);
            num /= 10;
        }

        int reversedNum = 0;
        int placeValue = 1;

        while (!stack.isEmpty()) {
            int digit = stack.pop();
            reversedNum += digit * placeValue;
            placeValue *= 10;
        }

        return reversedNum;
    }

    public static void main(String[] args) {
        int num1 = 365;
        System.out.println(reverseNumber(num1)); // Output: 563

        int num2 = 6899;
        System.out.println(reverseNumber(num2)); // Output: 9986
    }
}

6)
import java.util.*;

public class ReverseKElementsQueue {
    public static void reverseKElements(Queue<Integer> queue, int k) {
        if (k < 0 || k > queue.size()) {
            return;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        int k = 3;
        reverseKElements(queue, k);

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " "); // Output: 3 2 1 4 5
        }
    }
}

7)
import java.util.*;

public class PairwiseDestruction {
    public static int countWordsLeft(String[] words) {
        Stack<String> stack = new Stack<>();

        for (String word : words) {
            if (!stack.isEmpty() && stack.peek().equals(word)) {
                stack.pop();
            } else {
                stack.push(word);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        String[] words1 = {"ab", "aa", "aa", "bcd", "ab"};
        System.out.println(countWordsLeft(words1)); // Output: 3

        String[] words2 = {"tom", "jerry", "jerry", "tom"};
        System.out.println(countWordsLeft(words2)); // Output: 0
    }
}

8)
public class NearestSmallerElements {
    public static int maxAbsDifference(int[] arr) {
        int n = arr.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        leftSmaller[0] = 0;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] >= arr[i]) {
                j = leftSmaller[j];
            }
            leftSmaller[i] = j;
        }

        rightSmaller[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < n && arr[j] >= arr[i]) {
                j = rightSmaller[j];
            }
            rightSmaller[i] = j;
        }

        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(leftSmaller[i] - rightSmaller[i]);
            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 8};
        System.out.println(maxAbsDifference(arr1)); // Output: 1

        int[] arr2 = {2, 4, 8, 7, 7, 9, 3};
        System.out.println(maxAbsDifference(arr2)); // Output: 4

        int[] arr3 = {5, 1, 9, 2, 5, 1, 7};
        System.out.println(maxAbsDifference(arr3)); // Output: 1
    }
}
