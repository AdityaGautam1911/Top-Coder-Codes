// import java.util.*;

// class Node {
// int data;
// Node next;

// Node(int data) {
// this.data = data;
// this.next = null;
// }
// }

// public class reverse_k_ll {
// static Node reverse(Node head) {
// Node curr = head;
// Node prev = null;
// while (curr != null) {
// Node front = curr.next;
// curr.next = prev;
// prev = curr;
// curr = front;
// }
// return prev;
// }

// // Function to get the Kth node from a given position in the linked list
// static Node getKthNode(Node temp, int k) {
// // Decrement K as we already start from the 1st node
// k -= 1;

// // Decrement K until it reaches the desired position
// while (temp != null && k > 0) {
// k--;
// temp = temp.next;
// }

// // Return the Kth node
// return temp;
// }

// // Function to reverse nodes in groups of K
// static Node kReverse(Node head, int k) {
// // Initialize a temporary node to traverse the list
// Node temp = head;

// // Initialize a pointer to track the last node of the previous group
// Node prevLast = null;

// // Traverse through the linked list
// while (temp != null) {

// // Get the Kth node of the current group
// Node kThNode = getKthNode(temp, k);

// // If the Kth node is NULL
// // (not a complete group)
// if (kThNode == null) {

// // If there was a previous group,
// // link the last node to the current node
// if (prevLast != null) {
// prevLast.next = temp;
// }

// // Exit the loop
// break;
// }

// // Store the next node
// // after the Kth node
// Node nextNode = kThNode.next;

// // Disconnect the Kth node
// // to prepare for reversal
// kThNode.next = null;

// // Reverse the nodes from
// // temp to the Kth node
// reverse(temp);

// // Adjust the head if the reversal
// // starts from the head
// if (temp == head) {
// head = kThNode;
// } else {
// // Link the last node of the previous
// // group to the reversed group
// prevLast.next = kThNode;
// }

// // Update the pointer to the
// // last node of the previous group
// prevLast = temp;

// // Move to the next group
// temp = nextNode;
// }
// return head;
// }

// static void printLinkedList(Node head) {
// Node temp = head;
// while (temp != null) {
// System.out.print(temp.data + " ");
// temp = temp.next;
// }
// System.out.println();
// }

// public static void main(String[] args) {
// Node head = new Node(5);
// head.next = new Node(4);
// head.next.next = new Node(3);
// head.next.next.next = new Node(7);
// head.next.next.next.next = new Node(9);
// head.next.next.next.next.next = new Node(2);

// System.out.print("Original Linked List: ");
// printLinkedList(head);
// head = kReverse(head, 4);

// System.out.print("Reversed Linked List: ");
// printLinkedList(head);
// }
// }