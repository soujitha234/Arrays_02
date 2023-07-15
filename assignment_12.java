1)
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListUtils {
    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        prev.next = slow.next;

        return head;
    }

    public static void printLinkedList(ListNode head) {
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

        head = deleteMiddle(head);
        printLinkedList(head);
    }
}

2)
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListUtils {
    public static boolean hasLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = head.next; // Creating a loop

        boolean hasLoop = hasLoop(head);
        System.out.println(hasLoop);
    }
}

3)
  class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListUtils {
    public static ListNode findNthNodeFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);

        int n = 2;
        ListNode nthNode = findNthNodeFromEnd(head, n);
        if (nthNode != null) {
            System.out.println(nthNode.val);
        } else {
            System.out.println("Invalid value of N");
        }
    }
}

4)
class ListNode {
    char val;
    ListNode next;

    ListNode(char val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListPalindrome {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversedHead = reverseList(slow);

        ListNode p1 = head;
        ListNode p2 = reversedHead;

        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode('R');
        head1.next = new ListNode('A');
        head1.next.next = new ListNode('D');
        head1.next.next.next = new ListNode('A');
        head1.next.next.next.next = new ListNode('R');

        ListNode head2 = new ListNode('C');
        head2.next = new ListNode('O');
        head2.next.next = new ListNode('D');
        head2.next.next.next = new ListNode('E');

        System.out.println(isPalindrome(head1)); // Output: true
        System.out.println(isPalindrome(head2)); // Output: false
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

public class RemoveLoopLinkedList {
    public static void removeLoop(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

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

        ListNode start = head;

        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }

        ListNode prev = null;
        ListNode curr = start;

        while (curr.next != start) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = head.next;

        removeLoop(head);

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
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

public class DeleteNodes {
    public static ListNode deleteNodes(ListNode head, int M, int N) {
        if (head == null || M <= 0 || N <= 0) {
            return head;
        }

        ListNode curr = head;
        int count = 1;

        while (curr != null) {
            if (count % M == 0) {
                int k = N;
                ListNode temp = curr.next;

                while (k > 0 && temp != null) {
                    temp = temp.next;
                    k--;
                }

                curr.next = temp;
            }

            curr = curr.next;
            count++;
        }

        return head;
    }

    public static void printLinkedList(ListNode head) {
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
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        int M = 2;
        int N = 2;

        System.out.print("Original Linked List: ");
        printLinkedList(head);

        head = deleteNodes(head, M, N);

        System.out.print("Modified Linked List: ");
        printLinkedList(head);
    }
}

7)
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class InsertAlternate {
    public static void insertAlternate(ListNode first, ListNode second) {
        if (first == null || second == null) {
            return;
        }

        ListNode curr1 = first;
        ListNode curr2 = second;

        while (curr1 != null && curr2 != null) {
            ListNode temp1 = curr1.next;
            ListNode temp2 = curr2.next;

            curr1.next = curr2;
            curr2.next = temp1;

            curr1 = temp1;
            curr2 = temp2;
        }

        second = curr2;
    }

    public static void printLinkedList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(5);
        first.next = new ListNode(7);
        first.next.next = new ListNode(17);
        first.next.next.next = new ListNode(13);
        first.next.next.next.next = new ListNode(11);

        ListNode second = new ListNode(12);
        second.next = new ListNode(10);
        second.next.next = new ListNode(2);
        second.next.next.next = new ListNode(4);
        second.next.next.next.next = new ListNode(6);

        System.out.print("First Linked List: ");
        printLinkedList(first);

        System.out.print("Second Linked List: ");
        printLinkedList(second);

        insertAlternate(first, second);

        System.out.print("Modified First Linked List: ");
        printLinkedList(first);

        System.out.print("Modified Second Linked List: ");
        printLinkedList(second);
    }
}

8)
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class CircularLinkedList {
    public static boolean isCircular(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head; // making it circular

        boolean isCircular = isCircular(head);
        System.out.println("Is the linked list circular? " + isCircular);
    }
}
