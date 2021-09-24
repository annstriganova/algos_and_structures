package methods;

import java.util.Scanner;

/**
 * https://stepik.org/lesson/13240/step/8?unit=3426
 * Max-binary-heap
 */
public class PriorityQueue {
    private static final int INITIAL_SIZE = 100000;
    // queue[0] = max
    private int[] queue;
    private int HEAP_SIZE;

    public PriorityQueue() {
        queue = new int[INITIAL_SIZE];
        HEAP_SIZE = 0;
    }

    public void insert(int p) {
        queue[HEAP_SIZE] = p;
        shiftUp(HEAP_SIZE++);
    }

    public int extractMax() {
        int max = queue[0];
        --HEAP_SIZE;
        queue[0] = queue[HEAP_SIZE];
        queue[HEAP_SIZE] = 0;
        shiftDown(0);
        System.out.println(max);
        return max;
    }

    /**
     * @param i - index of a node, from which shifting should start
     */
    private void shiftUp(int i) {
        int startNode = queue[i];
        int parentIndex = (i - 1) / 2;
        int parent = queue[parentIndex];
        if (parentIndex == i || parent >= startNode) return;
        // swap parent <-> child
        queue[parentIndex] = startNode;
        queue[i] = parent;
        shiftUp(parentIndex);
    }

    /**
     * @param i - index of a node, from which shifting should start
     */
    private void shiftDown(int i) {
        int startNode = queue[i];
        int leftChildIndex = 2 * i + 1;
        int leftChild = queue[leftChildIndex];
        int rightChildIndex = leftChildIndex + 1;
        int rightChild = queue[rightChildIndex];
        // select the biggest child
        if (leftChild >= rightChild && startNode < leftChild){
            // swap parent <-> left child
            queue[i] = leftChild;
            queue[leftChildIndex] = startNode;
            // walk through left subtree
            shiftDown(leftChildIndex);
            return;
        }
        if (leftChild < rightChild && startNode < rightChild) {
            // swap parent <-> right child
            queue[i] = rightChild;
            queue[rightChildIndex] = startNode;
            // walk through right subtree
            shiftDown(rightChildIndex);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < HEAP_SIZE; i++) {
            sb.append(queue[i]);
            if (i != HEAP_SIZE - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine()); // number of operations
        PriorityQueue pq = new PriorityQueue();
        for (int i = 0; i < n; i++) {
            String line = s.nextLine();
            String[] op = line.split(" ");
            switch (op[0]) {
                case "Insert":
                    pq.insert(Integer.parseInt(op[1]));
                    break;
                case "ExtractMax":
                    pq.extractMax();
                    break;
                default:
                    throw new UnsupportedOperationException("Incorrect operation: " + op[0]);
            }
        }
    }
}
