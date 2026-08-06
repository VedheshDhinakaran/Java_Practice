
package dsa;

//Class representing a node in the linked list
class Node {
 int data;
 Node next;
 
 Node(int new_data) {
     this.data = new_data;
     this.next = null;
 }
}

//Class to implement stack using a singly linked list
class Stack2 {

 // Head of the linked list
 Node head;

 // Track current size of the stack
 int currentSize;

 // Define a maximum size for the stack
 int maxSize;

 // Constructor to initialize the stack with a maximum size
 Stack2(int maxSize) {
     this.head = null;
     this.currentSize = 0;
     this.maxSize = maxSize;
 }

 // Function to check if the stack is empty
 boolean isEmpty() {
     return head == null;
 }

 // Function to push an element onto the stack
 void push(int new_data) {

     // Check for stack overflow
     if (currentSize >= maxSize) {
         System.out.println("\nStack Overflow");
         return;
     }

     // Create a new node with given data
     Node new_node = new Node(new_data);

     // Link the new node to the current top node
     new_node.next = head;

     // Update the top to the new node
     head = new_node;

     // Increment the size of the stack
     currentSize++;
 }

 // Function to remove the top element from the stack
 void pop() {

     // Check for stack underflow
     if (isEmpty()) {
         System.out.println("\nStack Underflow");
         return;
     } else {

         // Assign the current top to a temporary variable
         Node temp = head;

         // Update the top to the next node
         head = head.next;

         // Decrement the size of the stack
         currentSize--;

         // Deallocate the memory of the old top node
         temp = null;
     }
 }

 // Function to return the top element of the stack
 int peek() {

     // If stack is not empty, return the top element
     if (!isEmpty())
         return head.data;
     else {
         System.out.println("\nStack is empty");
         return Integer.MIN_VALUE;
     }
 }
}

//Driver code
public class stackLL {
 public static void main(String[] args) {

     // Creating a stack with a maximum size of 3
     Stack2 st = new Stack2(3);

     // Push elements onto the stack
     st.push(11);
     st.push(22);
     st.push(33);

     // Attempt to push another element (should cause overflow)
     st.push(44);

     // Print top element of the stack
     System.out.println("Top element is " + st.peek());

     // Remove two elements from the top
     System.out.println("Removing two elements...");
     st.pop();
     st.pop();

     // Print top element of the stack
     System.out.println("Top element is " + st.peek());
 }
}
