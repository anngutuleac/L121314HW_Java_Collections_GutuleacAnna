package TickTock;

class TickTockThread implements Runnable {
    private Thread thrd;
    private String[] arr = {"Tick", "Tock"};
    private String separator = "-";

    TickTockThread() {
        thrd = new Thread(this);
        thrd.start();
    }

    public void run() {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
            if (i == arr.length - 1) { break; }
            System.out.print(separator);
            sleepFor(500);
        }
    }

    private void sleepFor(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }
}
