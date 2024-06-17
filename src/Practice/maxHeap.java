package Practice;

public class maxHeap {

    public int heap[];
    public int index;
    public int size;

    public maxHeap(int size) {
        this.heap = new int[size];
        this.size = size;
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

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int i) {
        if (index >= size) {
            System.out.println("Oops... heap is full");
            return;
        }
        heap[index] = i;
        int current = index++;
        while (heap[parent(current)] < heap[current]) {
            swap(current, parent(current));
            current = parent(current);
        }

    }

    public int remove() {
        int pop = heap[0];
        heap[0] = heap[--index];
        heapify(0);
        return pop;
    }

    public void heapify(int i) {
        if (!isLeaf(i)) {
            if (heap[leftChild(i)] > heap[i] || heap[rightChild(i)] > heap[i]) {
                if (heap[leftChild(i)] > heap[rightChild(i)]) {
                    swap(i, leftChild(i));
                    heapify(leftChild(i));
                } else {
                    swap(i, rightChild(i));
                    heapify(rightChild(i));

                }
            }
        }
    }

    public void buildheap() {
        for (int i = index; i >= 1; i--) {
            heapify(i);
        }
    }

    public void printHeap() {
        for (int i = 0; i < index / 2; i++) {
            System.out.print("Parent : " + heap[i]);
            if (leftChild(i) < index) {
                System.out.print(" Left Child : " + heap[leftChild(i)]);
            }
            if (rightChild(i) < index) {
                System.out.print(" Right Child : " + heap[rightChild(i)]);
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        maxHeap heap = new maxHeap(8);

        heap.insert(5);
        heap.insert(13);
        heap.insert(7);
        heap.insert(55);
        heap.insert(21);
        heap.insert(12);
        heap.insert(9);
        heap.insert(16);
        heap.buildheap();

        heap.printHeap();

        heap.remove();
        heap.printHeap();

    }

}
