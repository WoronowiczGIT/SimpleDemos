package SDA.IntiveISSTracker.Threads;

public class ReadingData extends Thread {


    public void run() {
        int count=0;
        while(true){
            System.out.println("i am reading"+count);
            try {
                this.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
