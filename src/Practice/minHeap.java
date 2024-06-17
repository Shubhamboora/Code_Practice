package Practice;

import java.util.Arrays;

public class minHeap {
    int heap[];
    int size;
    int index;

    public minHeap(int size) {
        this.size = size;
        heap = new int[size];
        this.index = 0;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        return (i * 2) + 1;
    }

    public int rightChild(int i) {
        return (i * 2) + 2;
    }

    public boolean isLeaf(int i) {
        if (leftChild(i) >= size || rightChild(i) >= size) {
            return true;
        } else {
            return false;
        }
    }

    public void insert(int val) {
        if (index >= size) {
            System.out.println("Oops... seems like heap is full");
            return;
        }

        heap[index] = val;
        int current = index++;

        while (heap[parent(current)] > heap[current]) {
            int temp = heap[parent(current)];
            heap[parent(current)] = heap[current];
            heap[current] = temp;

            current = parent(current);
        }
    }


    public void heapify(int i) {
        if (!isLeaf(i)) {
            if (heap[i] > heap[leftChild(i)] || heap[i] > heap[rightChild(i)]) {
                if (heap[leftChild(i)] < heap[rightChild(i)]) {
                    int temp = heap[i];
                    heap[i] = heap[leftChild(i)];
                    heap[leftChild(i)] = temp;
                    heapify(leftChild(i));
                } else {
                    int temp = heap[i];
                    heap[i] = heap[rightChild(i)];
                    heap[rightChild(i)] = temp;
                    heapify(rightChild(i));
                }
            }
        }
    }

    public int remove() {
        int pop = heap[0];
        heap[0] = heap[--index];
        heapify(0);
        return pop;

    }

    public void minHeap() {
        for (int i = index; i >= 1; i--) {
            heapify(i);
        }
    }

    // Function to print the contents of the heap
    public void printHeap() {
        for (int i = 0; i < (index / 2); i++) {
            System.out.print("Parent : " + heap[i]);
            if (leftChild(i) < index)
                System.out.print(" Left : " + heap[leftChild(i)]);
            if (rightChild(i) < index)
                System.out.print(" Right :" + heap[rightChild(i)]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        minHeap minHeap = new minHeap(8);
        minHeap.insert(3);
        minHeap.insert(13);
        minHeap.insert(7);
        minHeap.insert(16);
        minHeap.insert(21);
        minHeap.insert(12);
        minHeap.insert(9);
        minHeap.insert(5);
        minHeap.minHeap();

        System.out.println("The Min Heap is : " + Arrays.toString(minHeap.heap));
        minHeap.printHeap();
        System.out.println("\nThe Min Value is : " + minHeap.remove());
        System.out.println("\nThe Min Heap is :" + Arrays.toString(minHeap.heap));
        minHeap.printHeap();


    }

}
