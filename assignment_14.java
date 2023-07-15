1)
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveLoopLinkedList {
    public static void removeLoop(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        boolean hasLoop = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }

        if (!hasLoop) {
            return;
        }

        Node start = head;

        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }

        Node prev = null;
        Node curr = start;

        while (curr.next != start) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = head.next;

        removeLoop(head);

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

2)
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class AddOneToLinkedList {
    public static Node addOne(Node head) {
        Node reversed = reverseList(head);

        int carry = 1;
        Node curr = reversed;

        while (curr != null) {
            int sum = curr.data + carry;
            curr.data = sum % 10;
            carry = sum / 10;

            if (carry == 0) {
                break;
            }

            curr = curr.next;
        }

        if (carry != 0) {
            Node newNode = new Node(carry);
            newNode.next = reversed;
            reversed = newNode;
        }

        return reverseList(reversed);
    }

    private static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void printList(Node head) {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);

        printList(head);

        head = addOne(head);

        printList(head);
    }
}

3)
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }
}

public class FlattenLinkedList {
    public static Node flattenLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        head = mergeLists(head, head.next);

        head = mergeRemainingLists(head);

        return head;
    }

    private static Node mergeLists(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        Node result;

        if (a.data < b.data) {
            result = a;
            result.bottom = mergeLists(a.bottom, b);
        } else {
            result = b;
            result.bottom = mergeLists(a, b.bottom);
        }

        return result;
    }

    private static Node mergeRemainingLists(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node nextList = head.next;
        Node remainingLists = mergeRemainingLists(nextList);

        head.next = remainingLists;

        return mergeLists(head, nextList);
    }

    public static void printFlattenedList(Node head) {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.bottom;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(19);
        head.next.next.next = new Node(28);

        head.bottom = new Node(7);
        head.next.bottom = new Node(20);
        head.next.next.bottom = new Node(22);
        head.next.next.next.bottom = new Node(35);

        head.bottom.bottom = new Node(8);
        head.next.bottom.bottom = new Node(50);
        head.next.next.bottom.bottom = new Node(40);

        head.bottom.bottom.bottom = new Node(30);
        head.next.bottom.bottom.bottom = new Node(45);

        printFlattenedList(head);

        head = flattenLinkedList(head);

        printFlattenedList(head);
    }
}

4)
class Node {
    int data;
    Node next;
    Node arb;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.arb = null;
    }
}

public class CopyLinkedList {
    public static Node copyList(Node head) {
        if (head == null) {
            return null;
        }

        // Create a copy of each node and insert it next to the original node
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.data);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.arb != null) {
                curr.next.arb = curr.arb.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node copyHead = curr.next;
        Node copyCurr = copyHead;

        while (curr != null) {
            curr.next = curr.next.next;
            curr = curr.next;

            if (copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
                copyCurr = copyCurr.next;
            }
        }

        return copyHead;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head.arb = head.next.next;
        head.next.arb = head.next.next.next;

        Node copyHead = copyList(head);
        printList(copyHead);
    }
}

5)
  class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode odd = oddHead;
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return oddHead;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reorderedList = oddEvenList(head);
        printList(reorderedList);
    }
}

6)
  class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LeftShiftLinkedList {
    public static ListNode leftShift(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        int length = getLength(head);

        // Adjust the value of k to be within the range of the length of the linked list
        k = k % length;

        if (k == 0) {
            return head; // No need to perform left shift
        }

        ListNode prev = null;
        ListNode curr = head;

        // Move curr k positions ahead
        for (int i = 0; i < k; i++) {
            prev = curr;
            curr = curr.next;
        }

        // Connect the last node of the original list with the head of the shifted list
        prev.next = null;

        // Traverse to the end of the shifted list
        ListNode temp = curr;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Connect the original list to the end of the shifted list
        temp.next = head;

        return curr;
    }

    private static int getLength(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(9);

        int k = 3;

        ListNode shiftedList = leftShift(head, k);
        printList(shiftedList);
    }
}

7)
  import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class NextGreaterNode {
    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> values = new ArrayList<>();

        // Convert the linked list into an array
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        int[] result = new int[values.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = values.size() - 1; i >= 0; i--) {
            int value = values.get(i);

            // Pop elements from the stack until finding a greater element
            while (!stack.isEmpty() && value >= stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = 0; 
            } else {
                result[i] = stack.peek(); 
            }

            stack.push(value); 
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);

        int[] result = nextLargerNodes(head);

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveZeroSumSublists {
    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, dummy);

        int prefixSum = 0;

        while (head != null) {
            prefixSum += head.val;

            if (prefixSumMap.containsKey(prefixSum)) {
                ListNode prev = prefixSumMap.get(prefixSum);
                ListNode start = prev.next;
                int currSum = prefixSum;

                while (start != head) {
                    currSum += start.val;
                    prefixSumMap.remove(currSum);
                    start = start.next;
                }
                prev.next = head.next;
            } else {
                prefixSumMap.put(prefixSum, head);
            }

            head = head.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);

        ListNode result = removeZeroSumSublists(head);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
