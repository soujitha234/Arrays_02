1)
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeLinkedLists {
    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        ListNode head = null;
        ListNode tail = null;

        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                if (head == null) {
                    head = list1;
                    tail = list1;
                } else {
                    tail.next = list1;
                    tail = tail.next;
                }
                list1 = list1.next;
            } else {
                if (head == null) {
                    head = list2;
                    tail = list2;
                } else {
                    tail.next = list2;
                    tail = tail.next;
                }
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            tail.next = list1;
        }

        if (list2 != null) {
            tail.next = list2;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(5);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(8);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(7);
        list2.next.next = new ListNode(4);
        list2.next.next.next = new ListNode(5);

        ListNode mergedList = mergeLists(list1, list2);

        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
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

public class RemoveDuplicatesLinkedList {
    public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(11);
        head.next = new ListNode(11);
        head.next.next = new ListNode(11);
        head.next.next.next = new ListNode(21);
        head.next.next.next.next = new ListNode(43);
        head.next.next.next.next.next = new ListNode(43);
        head.next.next.next.next.next.next = new ListNode(60);

        ListNode updatedList = removeDuplicates(head);

        while (updatedList != null) {
            System.out.print(updatedList.val + " ");
            updatedList = updatedList.next;
        }
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

public class ReverseKNodesLinkedList {
    public static ListNode reverseKNodes(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null) {
            ListNode curr = prev.next;
            ListNode tail = curr;

            for (int i = 1; i < k && tail.next != null; i++) {
                tail = tail.next;
            }

            if (tail.next == null) {
                break; // Not enough nodes left, exit the loop
            }

            ListNode next = tail.next;
            tail.next = null; // Cut off the sublist
            prev.next = reverseList(curr); // Reverse the sublist
            curr.next = next; // Connect the reversed sublist with the remaining list
            prev = curr; // Move the pointer to the current sublist
        }

        return dummy.next;
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        int k = 4;

        ListNode reversedList = reverseKNodes(head, k);

        while (reversedList != null) {
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;
        }
    }
}

4)
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseAlternateKNodesLinkedList {
    public static ListNode reverseAlternateKNodes(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        boolean reverse = true;

        int count = 0;

        while (curr != null && count < k) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (reverse) {
            head.next = reverseAlternateKNodes(curr, k);
            return prev;
        } else {
            prev.next = reverseAlternateKNodes(curr, k);
            return head;
        }
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

        int k = 3;

        ListNode reversedList = reverseAlternateKNodes(head, k);

        while (reversedList != null) {
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;
        }
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

public class DeleteLastOccurrenceLinkedList {
    public static ListNode deleteLastOccurrence(ListNode head, int key) {
        if (head == null) {
            return null;
        }

        ListNode lastOccurrence = null;
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == key) {
                lastOccurrence = curr;
            }
            curr = curr.next;
        }

        if (lastOccurrence == null) {
            return head;
        }

        if (lastOccurrence == head) {
            head = head.next;
        } else {
            curr = head;
            while (curr != lastOccurrence) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(10);

        int key = 2;

        ListNode updatedList = deleteLastOccurrence(head, key);

        while (updatedList != null) {
            System.out.print(updatedList.val + " ");
            updatedList = updatedList.next;
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

public class MergeTwoSortedLists {
    public static ListNode mergeLists(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if (a != null) {
            tail.next = a;
        }
        if (b != null) {
            tail.next = b;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(5);
        a.next = new ListNode(10);
        a.next.next = new ListNode(15);

        ListNode b = new ListNode(2);
        b.next = new ListNode(3);
        b.next.next = new ListNode(20);

        ListNode mergedList = mergeLists(a, b);

        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}

7)
class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class ReverseDoublyLinkedList {
    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node prev = null;

        while (current != null) {
            // Swap prev and next pointers
            Node next = current.next;
            current.next = prev;
            current.prev = next;

            // Move to the next node
            prev = current;
            current = next;
        }

        return prev; // New head of the reversed list
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(8);
        head.next.next = new Node(4);
        head.next.next.next = new Node(2);

        Node reversedHead = reverseList(head);

        // Print the reversed list
        while (reversedHead != null) {
            System.out.print(reversedHead.data + " ");
            reversedHead = reversedHead.next;
        }
    }
}

8)
class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DeleteNodeDoublyLinkedList {
    public static Node deleteNode(Node head, int position) {
        if (head == null) {
            return null; // Empty list
        }

        if (position == 1) {
            Node newHead = head.next;
            if (newHead != null) {
                newHead.prev = null;
            }
            return newHead;
        }

        Node current = head;
        int count = 1;

        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return head; // Invalid position
        }

        Node prev = current.prev;
        Node next = current.next;

        if (prev != null) {
            prev.next = next;
        }

        if (next != null) {
            next.prev = prev;
        }

        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.prev = head;
        head.next.next = new Node(2);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(9);
        head.next.next.next.prev = head.next.next;

        int position1 = 3;
        Node updatedHead1 = deleteNode(head, position1);
        printList(updatedHead1); 

        int position2 = 1;
        Node updatedHead2 = deleteNode(head, position2);
        printList(updatedHead2);
    }
}
