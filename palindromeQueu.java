package dsa;


public class palindromeQueu {

    // Custom Queue class
    static class Queue {
        private int[] arr;
        private int front, rear, size, capacity;

        public Queue(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        // Enqueue operation
        public void enqueue(int item) {
            if (size == capacity) {
                throw new IllegalStateException("Queue is full");
            }
            rear = (rear + 1) % capacity;
            arr[rear] = item;
            size++;
        }

        // Dequeue operation
        public int dequeue() {
            if (size == 0) {
                throw new IllegalStateException("Queue is empty");
            }
            int item = arr[front];
            front = (front + 1) % capacity;
            size--;
            return item;
        }

        // Check if queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Get the size of the queue
        public int getSize() {
            return size;
        }

        // Get the element at the front of the queue
        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return arr[front];
        }
    }

    // Method to check if the queue is a palindrome
    public static boolean isPalindrome(Queue queue) {
        int[] temp = new int[queue.getSize()];
        int index = 0;

        // Copy the queue elements to an array
        while (!queue.isEmpty()) {
            temp[index++] = queue.dequeue();
        }

        // Re-enqueue the elements back to the queue
        for (int i = 0; i < temp.length; i++) {
            queue.enqueue(temp[i]);
        }

        // Check if the elements in the array form a palindrome
        int start = 0;
        int end = temp.length - 1;
        while (start < end) {
            if (temp[start] != temp[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);

        if (isPalindrome(queue)) {
            System.out.println("The queue is a palindrome.");
        } else {
            System.out.println("The queue is not a palindrome.");
        }
    }
}
