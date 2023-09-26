public class ProcessQueue {
    private Process[] heap;
    private int size;

    public ProcessQueue(int capacity) {
        heap = new Process[capacity];
        size = 0;
    }

    public void enqueue(Process process) {
        if (size == heap.length) {
            throw new IllegalStateException("Heap is full");
        }

        heap[size] = process;
        size++;

        bubbleUp(size - 1);
    }

    public Process dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        Process max = heap[0];
        heap[0] = heap[size - 1];
        size--;

        bubbleDown(0);

        return max;
    }

    private void bubbleUp(int i) {
        while (i > 0 && heap[parent(i)].getPriority() < heap[i].getPriority()) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void bubbleDown(int i) {
        int largest = i;

        while (true) {
            int left = leftChild(i);
            int right = rightChild(i);

            if (left < size && heap[left].getPriority() > heap[largest].getPriority()) {
                largest = left;
            }
            if (right < size && heap[right].getPriority() > heap[largest].getPriority()) {
                largest = right;
            }
            if (largest == i) {
                break;
            }

            swap(i, largest);
            i = largest;
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        Process temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int size() {
        return this.size;
    }
}
