import java.util.Arrays;

public class TestCorrectness {
    
    public static void main(String[] args) throws Exception {
        int queueSize = 7;
        QueueUsingStack qViaStack = new QueueUsingStack(queueSize);
        Queue queue = new Queue(queueSize);
        System.out.println("**** Enqueue Test ****");
        System.out.println();
        for (int i = 1; i <= 4; i++) {
            int x = i * 5;
            qViaStack.enqueue(x);
            queue.enqueue(x);
            System.out.println("Enqueue " + x);
            System.out.println("Stack implementation: " + qViaStack.toString());
            System.out.println("Standard implementation: " + queue.toString());
            System.out.println();
        }
        System.out.println("**** Dequeue Test ****");
        System.out.println();
        for (int i = 1; i <= 2; i++) {
            System.out.println("Stack implementation: (Dequeued " + qViaStack.dequeue() + ") " + qViaStack.toString());
            System.out.println("Standard implementation: (Dequeued " + queue.dequeue() + ") " + queue.toString());
            System.out.println();
        }
        System.out.println("**** Enqueue Test ****");
        System.out.println();
        for (int i = 1; i <= 5; i++) {
            int x = i * 7;
            qViaStack.enqueue(x);
            queue.enqueue(x);
            System.out.println("Enqueue " + x);
            System.out.println("Stack implementation: " + qViaStack.toString());
            System.out.println("Standard implementation: " + queue.toString());
            System.out.println();
        }
        System.out.println("**** Dequeue Test ****");
        System.out.println();
        for (int i = 1; i <= 7; i++) {
            System.out.println("Stack implementation: (Dequeued " + qViaStack.dequeue() + ") " + qViaStack.toString());
            System.out.println("Standard implementation: (Dequeued " + queue.dequeue() + ") " + queue.toString());
            System.out.println();
        }
        
        System.out.println("**** Odd/Even Stack ****\n");
        OddEvenStack os_stack = new OddEvenStack(8);
        int[] contents = { 2, 3, 12, 24, 33, 11, 21, 93, 6, 43 };
        for (int i = 0; i < contents.length; i++) {
            System.out.printf("Pushing %2d...", contents[i]);
            os_stack.push(contents[i]);
            System.out.println(" Stack content: " + os_stack);
        }
        System.out.println();
        System.out.println("Popping  odd: " + os_stack.popOdd());
        System.out.printf("Pushing %2d...", 100);
        os_stack.push(100);
        System.out.println(" Stack content: " + os_stack);
        System.out.println("Popping  odd: " + os_stack.popOdd());
        System.out.println("Popping  odd: " + os_stack.popOdd());
        System.out.println("Popping  odd: " + os_stack.popOdd());
        System.out.println("Popping  odd: " + os_stack.popOdd());
        System.out.println("Popping even: " + os_stack.popEven());
        System.out.println("Popping even: " + os_stack.popEven());
        System.out.println("Popping even: " + os_stack.popEven());
        System.out.println("Popping even: " + os_stack.popEven());
        System.out.print("Popping  odd: ");
        os_stack.popOdd();
        System.out.print("\nPopping even: ");
        os_stack.popEven();
        
        
        System.out.println("\n\n**** Sorting ****\n");
        int A[] = { 13, 17, 8, 14, 1 };
        System.out.println("Original Array: " + Arrays.toString(A));
        Sorting.selectionSort(A, A.length);
        System.out.println("Selection Sorted Array: " + Arrays.toString(A));
        
        System.out.println();
        
        int B[] = { -13, -17, -8, -14, -1, -20 };
        System.out.println("Original Array: " + Arrays.toString(B));
        Sorting.insertionSort(B, B.length);
        System.out.println("Insertion Sorted Array: " + Arrays.toString(B));
    }
}

