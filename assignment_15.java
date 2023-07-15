1)
import java.util.*;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        int[] result = nextGreaterElement(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
2)
import java.util.*;

public class NearestSmallerElement {
    public static int[] nearestSmallerElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 2};
        int[] result = nearestSmallerElement(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
3)
import java.util.*;

public class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        if (q1.isEmpty()) {
            return -1; // Stack is empty
        }

        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        int element = q1.poll();

        // Swap the queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return element;
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); 
        stack.push(4);
        System.out.println(stack.pop()); 
    }
}

4)
import java.util.*;

public class ReverseStack {
    static Stack<Integer> stack = new Stack<>();

    public static void reverseStack() {
        if (!stack.isEmpty()) {
            int element = stack.pop();
            reverseStack();
            insertAtBottom(element);
        }
    }

    public static void insertAtBottom(int element) {
        if (stack.isEmpty()) {
            stack.push(element);
        } else {
            int top = stack.pop();
            insertAtBottom(element);
            stack.push(top);
        }
    }

    public static void main(String[] args) {
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(7);
        stack.push(6);

        reverseStack();

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

5)
import java.util.*;

public class ReverseString {
    public static String reverseString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "GeeksforGeeks";
        System.out.println(reverseString(s)); // Output: skeeGrofskeeG
    }
}

6)
import java.util.*;

public class EvaluatePostfixExpression {
    public static int evaluatePostfixExpression(String postfix) {
        if (postfix == null || postfix.length() == 0) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        Stack<Integer> stack = new Stack<>();
        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operand1, operand2, c);
                stack.push(result);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return stack.pop();
    }

    private static int performOperation(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public static void main(String[] args) {
        String postfix = "231*+9-";
        System.out.println(evaluatePostfixExpression(postfix)); // Output: -4
    }
}

7)
import java.util.*;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Output: -3
        minStack.pop();
        System.out.println(minStack.top());    // Output: 0
        System.out.println(minStack.getMin()); // Output: -2
    }
}

8)
public class TrappingRainWater {
    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            waterTrapped += minHeight - height[i];
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height1)); // Output: 6

        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(height2)); // Output: 9
    }
}

