public class SyncBoundedQueue extends BoundedQueue {

    public SyncBoundedQueue(int size) {
        super(size);
    }

    synchronized public boolean isEmpty() {
        return super.isEmpty();
    }

    synchronized public boolean isFull() {
        return  super.isFull();
    }

    synchronized public int getCount() {
        return super.getCount();
    }

    synchronized public void put(Object e) {
        super.put(e);
    }

    synchronized public Object get() {
        return super.get();
    }

    public static void main(String args[]) {
        SyncBoundedQueue queue = new SyncBoundedQueue(5);
        new Producer(queue, 45).start();
        new Consumer(queue, 10).start();
    }
}

