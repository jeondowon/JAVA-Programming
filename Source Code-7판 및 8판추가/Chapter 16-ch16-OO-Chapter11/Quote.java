public class Quote extends Thread {

    protected int value;

    public Quote(int init) {
        value = init;
    }

    public void run() {
        try {
            for  (;;) {
                System.out.println(value);
                value += (Math.random() - 0.4) * (10.0 * Math.random());
                sleep(100);
            }
        } catch (InterruptedException e) {}
    }

    public static void main(String[] args) {
        new Quote(100).start();
    }
}